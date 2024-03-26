// Link to the problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
// Problem:
// Given the root of a binary search tree, and an integer k, 
// return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
\ 
// Example 1:
// Input: root = [3,1,4,null,2], k = 1
// Output: 1

// Example 2:
// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3
 

// Constraints:
// The number of nodes in the tree is n.
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104

//Solution: 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // a list to store all the values in the tree (store from small to bigger)
        List<Integer> values = new ArrayList<>();

        putInAcsending(root, values);
        //since the list starts from 0, get the k - 1'th vakue in list:
        return (values.get(k-1));
    }

    public void putInAcsending(TreeNode root, List<Integer> values) {
        // if it is root, then just return
        if (root == null) {
            return;
        }
        //go through the left side first
        putInAcsending(root.left, values);
        //add the root's value to the list(since doing after calling the left, it will be in ascending order)
        values.add(root.val);
        //go through the right side
        putInAcsending(root.right, values);
    }
}
