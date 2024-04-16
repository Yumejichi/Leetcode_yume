// Problem link: 
// 513. Find Bottom Left Tree Value
// Given the root of a binary tree, return the leftmost value in the last row of the tree.

// Example 1:
// Input: root = [2,1,3]
// Output: 1

// Example 2:
// Input: root = [1,2,3,4,null,5,6,null,null,7]
// Output: 7
 
// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1

// Solution:
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
    private int deepestLevelValue;
    private int maxDepth;
    public int findBottomLeftValue(TreeNode root) {
        deepestLevelValue = Integer.MIN_VALUE;
        maxDepth = Integer.MIN_VALUE;
        //recursively find the deepest value in the tree
        findLeftMostValue(root, 0);
        
        return deepestLevelValue;
    }

    private void findLeftMostValue(TreeNode node, int depth) {
        // base case, if there is no more node, just return
        if (node == null) {
            return;
        }

        // if the depth is bigger than the current depth, then update the value as the new deepest value
        if (depth > maxDepth) {
            maxDepth = depth;
            deepestLevelValue = node.val;
        }
        
        // recursively find the deepest value in left child and right child
        // do the left side to find the left child first
        findLeftMostValue(node.left, depth + 1);
        findLeftMostValue(node.right, depth + 1);

    }
}
