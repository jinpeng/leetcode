/** 
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * Example:
 *   Given nums = [2, 7, 11, 15], target = 9,
 *   Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
package twosum;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int idx=0; idx<nums.length; idx++) {
            for (int idx2=idx+1; idx2<nums.length; idx2++) {
                if (nums[idx] + nums[idx2] == target) {
                    return new int[] {idx, idx2};
                }
            }
        }
        return new int[0];
    }
}