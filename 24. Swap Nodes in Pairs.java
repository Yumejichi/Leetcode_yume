// Link to the problem: https://leetcode.com/problems/swap-nodes-in-pairs/description/
// Problem:
// Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
// Example 1:
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]

// Example 2:
// Input: head = []
// Output: []

// Example 3:
// Input: head = [1]
// Output: [1]
 
// Constraints:
// The number of nodes in the list is in the range [0, 100].
// 0 <= Node.val <= 100


//Solution: 
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        // result node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode result = new ListNode();
        result.next = head;
        ListNode current = head;
        ListNode prev = result;
        while ((current != null) && (current.next != null)) {
            //nodes to be swapped
            ListNode first = current;
            ListNode second = current.next;
            //swap first and second
            prev.next = second;
            first.next = second.next; 
            second.next = first;

            //next prev will be the priginal first node and the current will be the next of it
            prev = first;
            //go to next node
            current = first.next;
        }

        //return the head node which is the result.next
        return result.next;
        
    }
}
