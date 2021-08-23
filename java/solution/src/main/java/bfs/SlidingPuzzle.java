package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

/**
 * Developed by Lee Happily.
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * <p>
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        if (board.length != 2 && board[0].length != 3) {
            return -1;
        }
        int[][] target = {{1, 2, 3}, {4, 5, 0}};
        Set<String> visited = new HashSet<>();
        String targetSnapshot = snapshot(target);
        if (Objects.equals(targetSnapshot, snapshot(board))) {
            return 0;
        }
        LinkedList<int[][]> queue = new LinkedList<>();
        queue.offer(board);
        int times = -1;
        while (!queue.isEmpty()) {
            times++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[][] poll = queue.poll();
                if (Objects.equals(targetSnapshot, snapshot(poll))) {
                    return times;
                }
                int[] loc = getLocationOfSpace(poll);
                int row = loc[0];
                int col = loc[1];
//                System.out.println(snapshot(poll));
//                System.out.println("row:" + row + ", col:" + col);
                if (canSlidDown(row, poll)) {
                    int[][] down = slidDown(row, col, poll);
                    String snapshot = snapshot(down);
                    if (!visited.contains(snapshot)) {
//                        System.out.println(snapshot(poll) + "=>" + snapshot);
                        queue.offer(down);
                        visited.add(snapshot);
                    }
                }
                if (canSlidUp(row, poll)) {
                    int[][] up = slidUp(row, col, poll);
                    String snapshot = snapshot(up);
                    if (!visited.contains(snapshot)) {
//                        System.out.println(snapshot(poll) + "=>" + snapshot);
                        queue.offer(up);
                        visited.add(snapshot);
                    }
                }
                if (canSlidLeft(col, poll)) {
                    int[][] left = slidLeft(row, col, poll);
                    String snapshot = snapshot(left);
                    if (!visited.contains(snapshot)) {
//                        System.out.println(snapshot(poll) + "=>" + snapshot);
                        queue.offer(left);
                        visited.add(snapshot);
                    }
                }
                if (canSlidRight(col, board)) {
                    int[][] right = slidRight(row, col, poll);
                    String snapshot = snapshot(right);
                    if (!visited.contains(snapshot)) {
//                        System.out.println(snapshot(poll) + "=>" + snapshot);
                        queue.offer(right);
                        visited.add(snapshot);
                    }
                }
            }
        }
        return -1;
    }

    // row,col
    private int[] getLocationOfSpace(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean canSlidDown(int rowIdx, int[][] board) {
        return rowIdx < board.length - 1;
    }

    private int[][] slidDown(int rowIdx, int colIdx, int[][] board) {
        // copy entire array
        int[][] newArr = copyArray(board);
        int tmp = newArr[rowIdx][colIdx];
        newArr[rowIdx][colIdx] = newArr[rowIdx + 1][colIdx];
        newArr[rowIdx + 1][colIdx] = tmp;
        return newArr;
    }

    private boolean canSlidUp(int rowIdx, int[][] board) {
        return rowIdx > 0;
    }

    private int[][] slidUp(int rowIdx, int colIdx, int[][] board) {
        // copy entire array
        int[][] newArr = copyArray(board);
        int tmp = newArr[rowIdx][colIdx];
        newArr[rowIdx][colIdx] = newArr[rowIdx - 1][colIdx];
        newArr[rowIdx - 1][colIdx] = tmp;
        return newArr;
    }

    private boolean canSlidLeft(int colIdx, int[][] board) {
        return colIdx > 0;
    }

    private int[][] slidLeft(int rowIdx, int colIdx, int[][] board) {
        // copy entire array
        int[][] newArr = copyArray(board);
        int tmp = newArr[rowIdx][colIdx];
        newArr[rowIdx][colIdx] = newArr[rowIdx][colIdx - 1];
        newArr[rowIdx][colIdx - 1] = tmp;
        return newArr;
    }

    private boolean canSlidRight(int colIdx, int[][] board) {
        return colIdx < board[0].length - 1;
    }

    private int[][] slidRight(int rowIdx, int colIdx, int[][] board) {
        // copy entire array
        int[][] newArr = copyArray(board);
        int tmp = newArr[rowIdx][colIdx];
        newArr[rowIdx][colIdx] = newArr[rowIdx][colIdx + 1];
        newArr[rowIdx][colIdx + 1] = tmp;
        return newArr;
    }

    private int[][] copyArray(int[][] origin) {
        int[][] newArr = new int[origin.length][origin[0].length];
        for (int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, newArr[i], 0, origin[0].length);
        }
        return newArr;
    }

    // 快照，用于判断是否遍历过
    private String snapshot(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] rows : board) {
            for (int row : rows) {
                sb.append(row);
            }
        }
        return sb.toString();
    }
}



// 思路：这道题代码量大，但是难度一般，简单的 BFS 搞定。暴力破解大法好。