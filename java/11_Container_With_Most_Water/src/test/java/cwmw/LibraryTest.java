/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package cwmw;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        int[] input = new int[] {1,8,6,2,5,4,8,3,7};
        assertEquals(49, classUnderTest.maxArea(input));
    }
}
