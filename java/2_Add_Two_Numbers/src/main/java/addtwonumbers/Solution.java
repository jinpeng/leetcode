/** 
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except 
 * the number 0 itself.
 * Example:
 *   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *   Output: 7 -> 0 -> 8
 *   Explanation: 342 + 465 = 807.
 */
package addtwonumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
   
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode cursor = null;
        ListNode left = l1;
        ListNode right = l2;
        int carry = 0;
        int value = 0;
        while (left != null || right != null) {
            if (left != null && right != null) {
                value = left.val + right.val + carry;
                left = left.next;
                right = right.next;
            } else if (left != null) {
                value = left.val + carry;
                left = left.next;
            } else {
                value = right.val + carry;
                right = right.next;
            }
            if (value >= 10) {
                carry = 1;
                value -= 10;
            } else {
                carry = 0;
            }
            if (result == null) {
                result = new ListNode(value);
                cursor = result;
            } else {
                cursor.next = new ListNode(value);
                cursor = cursor.next;
            }
        }
        if (carry > 0) {
            cursor.next = new ListNode(carry);
            cursor = cursor.next;
        }
        return result;
    }
}
