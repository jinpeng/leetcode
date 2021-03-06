/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package itr;

import org.junit.Test;
import static org.junit.Assert.*;


/*
 * Example 1:
 * Input: 3
 * Output: "III"
 *
 * Example 2:
 * Input: 4
 * Output: "IV"
 *
 * Example 3:
 * Input: 9
 * Output: "IX"
 *
 * Example 4:
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Example 5:
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class LibraryTest {
    @Test public void testCaseOne() {
        Library classUnderTest = new Library();
        int input = 3;
        String expected = "III";
        assertEquals(expected, classUnderTest.intToRoman(input));
    }

    @Test public void testCaseTwo() {
        Library classUnderTest = new Library();
        int input = 4;
        String expected = "IV";
        assertEquals(expected, classUnderTest.intToRoman(input));
    }

    @Test public void testCaseThree() {
        Library classUnderTest = new Library();
        int input = 9;
        String expected = "IX";
        assertEquals(expected, classUnderTest.intToRoman(input));
    }

    @Test public void testCaseFour() {
        Library classUnderTest = new Library();
        int input = 58;
        String expected = "LVIII";
        assertEquals(expected, classUnderTest.intToRoman(input));
    }

    @Test public void testCaseFive() {
        Library classUnderTest = new Library();
        int input = 1994;
        String expected = "MCMXCIV";
        assertEquals(expected, classUnderTest.intToRoman(input));
    }

}
