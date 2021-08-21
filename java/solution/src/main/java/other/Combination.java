package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Developed by Lee Happily.
 */
public class Combination {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k < 0) {
            return res;
        }
        getCollection(new LinkedList<>(), 1, n, k);
        return res;
    }

    private void getCollection(LinkedList<Integer> selected, int min, int max, int num) {
        if (selected.size() == num) {
            res.add(new ArrayList<>(selected));
            return;
        }
        if (min > max) {
            return;
        }
        for (int i = min; i <= max; i++) {
            if (selected.contains(i)) {
                continue;
            }
            selected.add(i);
            getCollection(selected, i + 1, max, num);
            selected.removeLast();
        }
    }
}


// 思路：执行用时较长，仅打败了 7% 的提交，想了半天第二种思路也没有想出来，Shame！！！