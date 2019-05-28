/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rem;

import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Example 4:
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

 */
public class LibraryTest {
    @Test public void testCaseOne() {
        Library classUnderTest = new Library();
        String s = "aa";
        String p = "a";
        assertFalse("isMatch should return 'false'", classUnderTest.isMatch(s, p));
    }

    @Test public void testCaseTwo() {
        Library classUnderTest = new Library();
        String s = "aa";
        String p = "a*";
        assertTrue("isMatch should return 'true'", classUnderTest.isMatch(s, p));
    }

    @Test public void testCaseThree() {
        Library classUnderTest = new Library();
        String s = "ab";
        String p = ".*";
        assertTrue("isMatch should return 'true'", classUnderTest.isMatch(s, p));
    }

    @Test public void testCaseFour() {
        Library classUnderTest = new Library();
        String s = "aab";
        String p = "c*a*b";
        assertTrue("isMatch should return 'true'", classUnderTest.isMatch(s, p));
    }

    @Test public void testCaseFive() {
        Library classUnderTest = new Library();
        String s = "mississippi";
        String p = "mis*is*p*.";
        assertFalse("isMatch should return 'false'", classUnderTest.isMatch(s, p));
    }

    @Test public void testCaseSix() {
        Library classUnderTest = new Library();
        String s = "mississippi";
        String p = "*mis*is*p*.";
        assertFalse("isMatch should return 'false'", classUnderTest.isMatch(s, p));
    }

    @Test public void testCaseSeven() {
        Library classUnderTest = new Library();
        String s = "";
        String p = "";
        assertTrue("isMatch should return 'true'", classUnderTest.isMatch(s, p));
    }
}