/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font
 * for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
package zc;

class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows) return s;
        if (numRows == 1) return s;
        char[][] buf = new char[numRows][s.length()/2 + 1];
        int[] rowIdx = new int[numRows];
        for (int i=0; i<numRows; i++) rowIdx[i] = 0;
        int row = 0;
        boolean rowAscend = true;
        for (int i=0; i<s.length(); i++) {
            buf[row][rowIdx[row]++] = s.charAt(i);
            if (rowAscend) row ++;
            else row --;
            if (row == numRows - 1) rowAscend = false;
            if (row == 0) rowAscend = true;
        }
        StringBuilder result = new StringBuilder(s.length());
        for (int i=0; i<numRows; i++) {
            result.append(buf[i], 0, rowIdx[i]);
        }

        return result.toString();
    }
}