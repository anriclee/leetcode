package dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Developed by Lee Happily.
 * <p>
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 对区间按照 end 升序排列
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
                count++;
            }
        }
        return intervals.length - count;
    }
}


// 该问题转化为：总区间数 - 最多的不相交的区间数
// 最多不相交的区间：用贪心算法，先对区间按照 end 进行排序，每次都取 end 最小的。