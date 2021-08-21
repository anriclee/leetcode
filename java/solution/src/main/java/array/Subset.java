package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Developed by Lee Happily.
 * <p>
 * 给你一个整数数组 nums ，数组中的元素互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subset {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            LinkedList<Integer> selected = new LinkedList<>();
            getSubsetOfElements(selected, nums, i, 0);
        }
        return res;
    }

    private void getSubsetOfElements(LinkedList<Integer> selected, int[] nums, int elementNum, int startIdx) {
        if (selected.size() == elementNum) {
            res.add(new ArrayList<>(selected));
            return;
        }
        for (int i = startIdx; i < nums.length; i++) {
            if (selected.contains(nums[i])) {
                // 已经选择过了
                continue;
            }
            selected.add(nums[i]);
            getSubsetOfElements(selected, nums, elementNum, i);
            selected.removeLast();
        }
    }
}

// 思路：使用回溯框架解决子集类问题
// 每个长度为 N 的数组，子集都可以按照元素个数分为：0 ~ N

// 使用回溯框架做出来了，但是时间复杂度高

