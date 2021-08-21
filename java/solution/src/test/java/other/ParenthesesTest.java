package other;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class ParenthesesTest {

    @Test
    public void generateParenthesis() {
//        List<String> strings = new Parentheses().generateParenthesis(3);
//        System.out.println(strings);
        List<String> string2 = new Parentheses().generateParenthesis(1);
        System.out.println(string2);
    }
}