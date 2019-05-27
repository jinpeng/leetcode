/*
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output: 321
 * 
 * Example 2:
 * Input: -123
 * Output: -321
 * 
 * Example 3:
 * Input: 120
 * Output: 21
 * 
 * Note:
 * Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0
 * when the reversed integer overflows.
 */
package ri;

class Solution {
    public int reverse(int x) {
        boolean negative = x < 0 ? true:false;
        if (negative) x = 0 - x;
        // 2^31 = 2147483648
        int maxDigits = 10;
        int[] digits = new int[maxDigits];
        int numDigits = 0;
        int remaining = x;
        boolean leadingZero = true;
        long result = 0;
        while (remaining > 0) {
            if (leadingZero) {
                if (remaining % 10 != 0) {
                    leadingZero = false;
                }
            }
            if (!leadingZero) {
                digits[numDigits++] = remaining % 10;
            }
            remaining = remaining / 10;
        }
        for (int i=0; i<numDigits; i++) {
            result = result * 10 + digits[i];
        }
        if (negative) result = 0 - result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return (int)result;
    }
}