/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ri;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void testCaseOne() {
        Solution classUnderTest = new Solution();
        int input = 123;
        int expected = 321;
        assertEquals(expected, classUnderTest.reverse(input));
    }

    @Test
    public void testCaseTwo() {
        Solution classUnderTest = new Solution();
        int input = -123;
        int expected = -321;
        assertEquals(expected, classUnderTest.reverse(input));
    }

    @Test
    public void testCaseThree() {
        Solution classUnderTest = new Solution();
        int input = 120;
        int expected = 21;
        assertEquals(expected, classUnderTest.reverse(input));
    }

    @Test
    public void testCaseFour() {
        Solution classUnderTest = new Solution();
        int input = 901000;
        int expected = 109;
        assertEquals(expected, classUnderTest.reverse(input));
    }

    @Test
    public void testCaseFive() {
        Solution classUnderTest = new Solution();
        int input = 1534236469;
        int expected = 0;
        assertEquals(expected, classUnderTest.reverse(input));
    }
}
