
//Link to the problem: https://leetcode.com/problems/sort-list/description/
//Problem: 148. Sort List

// Given the head of a linked list, return the list after sorting it in ascending order. 

// Example 1:
// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:
// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]

// Example 3:
// Input: head = []
// Output: []
 
// Constraints:
// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105


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
    public ListNode sortList(ListNode head) {
        
        //base cases:
        //if the head is null or the next node does not exist(just one node):
        //just return head
        if(head==null || head.next==null){
            return head;
        }


        //split the linked list to half.
        //real mid will be the next node from the returned value from function
        ListNode mid = mid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        //sort the let part and the right part separately
        left = sortList(left);
        right = sortList(right);

        //merge the left part and right part
        return merge(left, right);        
    }


    //find the mid function
    private ListNode mid(ListNode head){
        //find the middle of the linked list:
        int count = 0;
        ListNode current = head;
        while(current.next != null){
            current = current.next;
            count++;
        }
        int midPoint = count/2; 
        ListNode mid = head;
        for(int i = 0; i<midPoint; i++){
            mid = mid.next;
        }
        return mid;

    }


    //merge function
    private ListNode merge(ListNode left, ListNode right){
        //create a dummy to return and the one tracking the current node
        ListNode current = new ListNode(0);
        ListNode result = current;


        //compare the left and right node and pick the smaller one
        while(left != null && right != null){
            //compare the values in left and right lists:
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;

        }


        //since when the while loop ends, one node might still not done, so add the left part
        if(left!=null){
            current.next = left;
        }
        if(right!=null){
            current.next = right;
        }
        //return the node result but start from the next one after 0
        return result.next;
    }

}
