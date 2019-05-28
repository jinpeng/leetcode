/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII,
 * which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral
 * for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract
 * it making four. The same principle applies to the number nine, which is written as IX. There are six instances
 * where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
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
package itr;

public class Library {
    /**
     * I -> 1, V -> 5, X -> 10, L -> 50, C -> 100, D -> 500, M -> 1000
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] digits = new int[4];
        int idx = 0;
        while (num > 0) {
            digits[idx++] = num % 10;
            num = num / 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=idx-1; i>=0; i--) {
            switch (i) {
                case 3:
                    while (digits[i] > 0) {
                        sb.append('M');
                        digits[i] --;
                    }
                    break;
                case 2:
                    if (digits[i] == 9) {
                        sb.append("CM");
                    } else if (digits[i] >= 5) {
                        sb.append('D');
                        while (digits[i] > 5) {
                            sb.append('C');
                            digits[i] --;
                        }
                    } else if (digits[i] == 4) {
                        sb.append("CD");
                    } else {
                        while (digits[i] > 0) {
                            sb.append('C');
                            digits[i] --;
                        }
                    }
                    break;
                case 1:
                    if (digits[i] == 9) {
                        sb.append("XC");
                    } else if (digits[i] >= 5) {
                        sb.append('L');
                        while (digits[i] > 5) {
                            sb.append('X');
                            digits[i] --;
                        }
                    } else if (digits[i] == 4) {
                        sb.append("XL");
                    } else {
                        while (digits[i] > 0) {
                            sb.append('X');
                            digits[i] --;
                        }
                    }
                    break;
                case 0:
                    if (digits[i] == 9) {
                        sb.append("IX");
                    } else if (digits[i] >= 5) {
                        sb.append('V');
                        while (digits[i] > 5) {
                            sb.append('I');
                            digits[i] --;
                        }
                    } else if (digits[i] == 4) {
                        sb.append("IV");
                    } else {
                        while (digits[i] > 0) {
                            sb.append('I');
                            digits[i] --;
                        }
                    }
                    break;
            }
        }

        return sb.toString();
    }
}
