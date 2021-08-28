package dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Developed by Lee Happily.
 */
public class PascalTriangleTest {

    @Test
    public void generate() {
//        List<List<Integer>> res = new PascalTriangle().generateDP(5);
//        System.out.println(Arrays.toString(res.toArray()));

        List<Integer> res1 = new PascalTriangle().generateV2(3);
        System.out.println(Arrays.toString(res1.toArray()));
    }
}