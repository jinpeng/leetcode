/*
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
package lps;

class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int maxLength = 0;
        for (int i=0; i<chars.length; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                if (right - left + 1 > maxLength) {
                    maxLength = right -left + 1;
                    start = left;
                }
                left --;
                right ++;
            }
        }

        for (int i=0; i<chars.length; i++) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                if (right - left + 1 > maxLength) {
                    maxLength = right -left + 1;
                    start = left;
                }
                left --;
                right ++;
            }
        }

        if (maxLength > 0)
            return s.substring(start, start + maxLength);
        else if (s.length() > 0)
            return s.substring(0, 1);
        return "";
    }
}
