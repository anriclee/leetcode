package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class CoinChangeTest {

    @Test
    public void coinChange() {
        // [186,419,83,408]
        //6249
        int[] coins = new int[]{186,419,83,408};
        int i = new CoinChange().coinChange(coins, 6249);
        System.out.println(i);
    }
}