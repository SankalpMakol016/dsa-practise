/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next.next;
    // Find the middle
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    // Reverse second half
    slow.next = reverse(slow.next);
    // Compare first half and reversed second half
    ListNode temp = head;
    ListNode tail = slow.next;
    int maxi = 0;
    while (tail != null) {
        maxi = Math.max(maxi, temp.val + tail.val);
        temp = temp.next;
        tail = tail.next;
    }
    return maxi;
}
ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode temp = head;
    while (temp != null) {
        ListNode ahead = temp.next;
        temp.next = prev;
        prev = temp;
        temp = ahead;
    }
    return prev;
}
}