package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class SubsetTest {

    @Test
    public void subsets() {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = new Subset().subsets(arr);
        System.out.println(Arrays.toString(subsets.toArray()));
    }
}