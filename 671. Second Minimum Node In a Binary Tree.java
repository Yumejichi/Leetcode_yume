// Problem Link: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
// Problem:
// Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
// Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
// If no such second minimum value exists, output -1 instead.

// Example 1:
// Input: root = [2,2,5,null,null,5,7]
// Output: 5
// Explanation: The smallest value is 2, the second smallest value is 5.

// Example 2:
// Input: root = [2,2,2]
// Output: -1
// Explanation: The smallest value is 2, but there isn't any second smallest value.
 
// Constraints:
// The number of nodes in the tree is in the range [1, 25].
// 1 <= Node.val <= 231 - 1
// root.val == min(root.left.val, root.right.val) for each internal node of the tree.

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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        // if it's a leaf node, then no second minimum, return -1:
        if (root.left == null && root.right ==null) {
            return -1;
        }
        // if the child's value is same, then find if there is a smaller one in there:
        // because the root.val = min(root.left.val, root.right.val) always holds, we will just need to find the second smaller root which can be checked from the top of the tree.
        // and if the children's value is not same, just compare current root and find the smaller one in the children
        int leftSmallestChildValue = root.left.val;
        int rightSmallestChildValue = root.right.val;
        if (root.left.val == root.val) {
            leftSmallestChildValue = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            rightSmallestChildValue = findSecondMinimumValue(root.right);
        }

        // get the smaller one in left and right children as the second min:
        if (leftSmallestChildValue == -1 && rightSmallestChildValue != -1) {
            return rightSmallestChildValue;
        } else if (rightSmallestChildValue == -1 && leftSmallestChildValue != -1) {
            return leftSmallestChildValue;
        } else if (rightSmallestChildValue != -1 && leftSmallestChildValue != -1) {
            return (Math.min(rightSmallestChildValue, leftSmallestChildValue));
        } else {
            return -1;
        }
    }
}
