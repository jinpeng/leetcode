/*
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
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
 *
 * Example 5:
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */

package rem;

public class Library {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)  return true;
        if (p.length() == 0 || p.charAt(0) == '*') return false;

        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && match[0][i-1]) {
                match[0][i+1] = true;
            }
        }

        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    // 该字符匹配成功，使用去掉1个字符的s子串和p子串的匹配结果，作为当前子串的匹配结果
                    match[i+1][j+1] = match[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    // 该字符匹配成功，使用去掉1个字符的s子串和p子串的匹配结果，作为当前子串的匹配结果
                    match[i+1][j+1] = match[i][j];
                }
                if (p.charAt(j) == '*') {
                    // 如果遇到 '*'
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        // 该字符和p中上一个字符匹配失败，使用当前s子串和去掉2个字符的p子串的匹配结果，作为当前子串的匹配结果
                        match[i+1][j+1] = match[i+1][j-1];
                    } else {
                        // 该字符和p中上一个字符匹配成功，使用下面三个匹配结果作与运算后的结果，作为当前子串的匹配结果
                        // 1. s子串去掉一个字符，和当前p子串的匹配结果 （in this case, a* counts as multiple a ）
                        // 2. s子串和p子串去掉1个字符的匹配结果（in this case, a* counts as single a）
                        // 3. s子串和p子串去掉2个字符的匹配结果（in this case, a* counts as empty）
                        match[i+1][j+1] = (match[i+1][j] || match[i][j+1] || match[i+1][j-1]);
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
