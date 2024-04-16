// Problem link: https://leetcode.com/problems/maximum-width-of-binary-tree/description/
// Problem:
// 662. Maximum Width of Binary Tree
// Given the root of a binary tree, return the maximum width of the given tree.
// The maximum width of a tree is the maximum width among all levels.
// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
// It is guaranteed that the answer will in the range of a 32-bit signed integer.

// Example 1:
// Input: root = [1,3,2,5,3,null,9]
// Output: 4
// Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

// Example 2:
// Input: root = [1,3,2,5,null,null,9,6,null,7]
// Output: 7
// Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

// Example 3:
// Input: root = [1,3,2,5]
// Output: 2
// Explanation: The maximum width exists in the second level with length 2 (3,2).
 
// Constraints:
// The number of nodes in the tree is in the range [1, 3000].
// -100 <= Node.val <= 100

// Soulution:
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // a list stores the index of the most left node at each depth
        List<Integer> listOfMostLeftIndex = new ArrayList<>();
        return maxWidth(root, 0, 1, listOfMostLeftIndex);


    }

    // recursive method for find the max width
    // The width of a tree at a certain depth is the number of nodes between 
    // the most left and the most right nodes at that depth.
    private int maxWidth(TreeNode node, int depth, int currentIndex, List<Integer> listOfMostLeftIndex) {
        
        
        // if the current node is null, return 0 since no width to consider
        if (node == null) {
            return 0;
        }


        // if the depth is the size of the listOfMostLeftIndex,
        // it means that we are visiting the depth for the first time
        // add the current node's index as the most left node's index at the depth
        if (depth == listOfMostLeftIndex.size()) {
            listOfMostLeftIndex.add(currentIndex);
        }

        // Calculate the width at current node by compare to the most left node at the same depth
        int width = currentIndex - listOfMostLeftIndex.get(depth) + 1;

        // Recursively calculate the maximum width from the left child
        int widthOfLeft = maxWidth(node.left, depth + 1, currentIndex * 2, listOfMostLeftIndex);
        // Recursively calculate the maximum width from the right child
        int widthOfRight = maxWidth(node.right, depth + 1, currentIndex * 2 + 1, listOfMostLeftIndex);

        // Return the maximum width found between the current width, left width, and right width
        return Math.max(width, Math.max(widthOfLeft, widthOfRight));

    }
}
