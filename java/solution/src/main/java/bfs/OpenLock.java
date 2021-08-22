package bfs;

import java.util.*;

/**
 * Developed by Lee Happily.
 * <p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，
 * 你需要给出解锁需要的*最小旋转次数*，如果无论如何不能解锁，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 * 通过次数65,764提交次数123,597
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> selected = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        String initNode = "0000";
        queue.offer(initNode);

        if (inDeadEnds(deadends, target) || inDeadEnds(deadends, initNode)) {
            return -1;
        }

        int times = 0;
        while (!queue.isEmpty()) {
            if (Objects.equals(queue.peek(), target)) {
                return times;
            }
            times++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.pollFirst();
                String[] branches = branches(s);
                for (String branch : branches) {
                    if (Objects.equals(target, branch)) {
                        return times;
                    }
                    if (selected.contains(branch)) {
                        // 之前选过
                        continue;
                    }
                    if (inDeadEnds(deadends, branch)) {
                        continue;
                    }
                    selected.add(branch);
                    queue.add(branch);
                }
            }
        }


        return -1;
    }

    private String[] branches(String node) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = node.toCharArray();
        char[] newChars = new char[4];
        for (int i = 0; i < chars.length; i++) {
            System.arraycopy(chars, 0, newChars, 0, 4);
            newChars[i] = increaseByOne(chars[i]);
            res.add(new String(newChars));

            newChars[i] = decreaseByOne(chars[i]);
            res.add(new String(newChars));
        }
        return convertToArray(res);
    }

    private char increaseByOne(char c) {
        if (c == '9') {
            return '0';
        }
        return (char) (c + '1' - '0');
    }

    private char decreaseByOne(char c) {
        if (c == '0') {
            return '9';
        }
        return (char) (c + '0' - '1');
    }

    private String[] convertToArray(ArrayList<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            array[i] = list.get(i);
        return array;
    }

    private boolean inDeadEnds(String[] deadends, String target) {
        for (String deadend : deadends) {
            if (Objects.equals(deadend, target)) {
                return true;
            }
        }
        return false;
    }
}


// 思路：
// 下一步可能的点可以看成是一颗多叉树，有的子节点通往死亡节点，有的通往目的解。重点是写出每个节点的分支。

