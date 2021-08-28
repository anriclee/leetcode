package dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class PascalTriangleTest {

    @Test
    public void generate() {
        List<List<Integer>> res = new PascalTriangle().generateV2(5);
        System.out.println(Arrays.toString(res.toArray()));
    }
}