// Link to the problem: https://leetcode.com/problems/swap-nodes-in-pairs/description/
// Problem:
// Given the root of a binary tree, turn the tree upside down and return the new root.

// You can turn a binary tree upside down with the following steps:

// The original left child becomes the new root.
// The original root becomes the new right child.
// The original right child becomes the new left child.
// The mentioned steps are done level by level. It is guaranteed that every right node has a sibling (a left node with the same parent) and has no children.

// Example 1:
// Input: root = [1,2,3,4,5]
// Output: [4,5,2,null,null,3,1]

// Example 2:
// Input: root = []
// Output: []

// Example 3:
// Input: root = [1]
// Output: [1]
 
// Constraints:
// The number of nodes in the tree will be in the range [0, 10].
// 1 <= Node.val <= 10
// Every right node in the tree has a sibling (a left node that shares the same parent).
// Every right node in the tree has no children.

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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return turnUpsideDown(root);
    }
    
    public TreeNode turnUpsideDown(TreeNode current) {
        // if no left child, return current
        if (current.left == null) {
            return current;
        }

        // go through the left side:
        TreeNode newRoot = turnUpsideDown(current.left);
        // set the current's left's left as current's right
        current.left.left = current.right;
        //set current's left's right as current
        current.left.right = current;
        // set the current's left and current's right to null
        current.left = null;
        current.right = null;
        return newRoot;
    }
}
