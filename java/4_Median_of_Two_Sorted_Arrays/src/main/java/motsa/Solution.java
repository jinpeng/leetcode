/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
package motsa;

import java.awt.MenuItem;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int pos1 = 0, pos2 = 0;
        int medianPos = 0;
        int median1 = -1, median2 = -1;
        int nextOne = 0;
        int count = -1;
        boolean nums1Exhausted = nums1.length == 0 ? true : false;
        boolean nums2Exhausted = nums2.length == 0 ? true : false;
        boolean twoMedian = false;
        if ((nums1.length + nums2.length) % 2 == 0) {
            twoMedian = true;
            medianPos = (nums1.length + nums2.length) / 2 - 1;
        } else {
            twoMedian = false;
            medianPos = (nums1.length + nums2.length - 1) / 2;
        }
        while (!nums1Exhausted || !nums2Exhausted) {
            if (!nums1Exhausted && !nums2Exhausted) {
                if (nums1[pos1] <= nums2[pos2]) {
                    nextOne = nums1[pos1];
                    if (pos1 < nums1.length - 1) {
                        pos1 += 1;
                    } else {
                        nums1Exhausted = true;
                    }
                } else {
                    nextOne = nums2[pos2];
                    if (pos2 < nums2.length - 1) {
                        pos2 += 1;
                    } else {
                        nums2Exhausted = true;
                    }
                }
            } else if (nums1Exhausted) {
                nextOne = nums2[pos2];
                if (pos2 < nums2.length - 1) {
                    pos2 += 1;
                } else {
                    nums2Exhausted = true;
                }
            } else {
                nextOne = nums1[pos1];
                if (pos1 < nums1.length - 1) {
                    pos1 += 1;
                } else {
                    nums1Exhausted = true;
                }
            }
            count ++;
            if (count == medianPos) {
                median1 = nextOne;
                if (!twoMedian) break;
            } else if ((count == medianPos + 1) && twoMedian) {
                median2 = nextOne;
                break;
            }
        }
        return twoMedian ? ((double)median1 + (double)median2)/2 : (double)median1;
    }

    public static void main(String[] args) {
        Solution classUnderTest = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        System.out.println(classUnderTest.findMedianSortedArrays(nums1, nums2));
    }
}