/*
 * Given a string, find the length of the longest substring without
 * repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 *              Note that the answer must be a substring, "pwke" is
 *              a subsequence and not a substring.
 */
package lswrc;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap map = new HashMap<Character, Integer>();
        int longestLength = 0;
        int searchStart = 0;
        int pos = 0;
        int lastCleared = 0;
        while (pos < chars.length) {
            if (map.containsKey(chars[pos])) {
                searchStart = (Integer)map.get(chars[pos]) + 1;
                for (int i=lastCleared; i<searchStart; i++) {
                    map.remove(chars[i]);
                }
                lastCleared = searchStart;
            }
            map.put(chars[pos], pos);
            if (longestLength < pos - searchStart + 1) {
                longestLength = pos - searchStart + 1;
            }
            pos ++;
        }
        return longestLength;
    }
}