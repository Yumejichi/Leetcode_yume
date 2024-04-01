// Link to the problem: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/
// Problem:
// Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
// Note:
// The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
// A subtree of root is a tree consisting of root and all of its descendants.
 
// Example 1:
// Input: root = [4,8,5,0,1,null,6]
// Output: 5
// Explanation: 
// For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
// For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
// For the node with value 0: The average of its subtree is 0 / 1 = 0.
// For the node with value 1: The average of its subtree is 1 / 1 = 1.
// For the node with value 6: The average of its subtree is 6 / 1 = 6.

// Example 2:
// Input: root = [1]
// Output: 1
// Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
 
// Constraints:
// The number of nodes in the tree is in the range [1, 1000].
// 0 <= Node.val <= 1000

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
    int count;
    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getAverage(root);
        return count;
        
    }

    private int[] getAverage(TreeNode root) {
        if (root == null) {
            int[] newInt = {0, 0};
            return newInt;
        }  
        int leftSum;
        int leftCount;
        int rightSum;
        int rightCount;
        // get the left node's sum and count
        int[] left = getAverage(root.left);
        leftSum = left[0];
        leftCount = left[1];
        
      // get the right node's sum and count
        int[] right = getAverage(root.right);
        rightSum = right[0];
        rightCount = right[1];

        // consider the current root's sum and count, calculate the average and rounded down to the nearest integer.
        int ave = (leftSum + rightSum + root.val) / (leftCount + rightCount + 1);

        // If average is same vith root's value, count should be increamented
        if (ave == root.val) {
            count++;
        }
        int[] res = new int[2];
        res[0] = leftSum + rightSum + root.val;
        res[1] = leftCount + rightCount + 1;
    return res;
    }
}
