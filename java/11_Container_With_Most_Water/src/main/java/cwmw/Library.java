/*
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
package cwmw;

public class Library {
    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i=0; i<height.length - 1; i++) {
            for (int j=i+1; j<height.length; j++) {
                int area = (j - i) * (height[i] < height[j] ? height[i]:height[j]);
                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
