package dp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class CountBitTest {

    @Test
    public void countBits() {
        int[] bits = new CountBit().countBits(8);
        System.out.println(Arrays.toString(bits));
    }
}