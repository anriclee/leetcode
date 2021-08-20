package binarytree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class ValidSerializationTest {

    @Test
    public void isValidSerialization() {
        String test = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String test1 = "9,#,92,#,#";
        String test2 = "9,#,#,1";
//        boolean res = new ValidSerialization().isValidSerialization(test);
//        System.out.println(res);
        boolean res1 = new ValidSerialization().isValidSerialization(test2);
        System.out.println(res1);
    }
}