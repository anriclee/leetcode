package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class CoinChangeV2Test {

    @Test
    public void change() {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        int change = new CoinChangeV2().change(amount, coins);
        System.out.println(change);
    }
}