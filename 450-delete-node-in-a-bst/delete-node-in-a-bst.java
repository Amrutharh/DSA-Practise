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

    public TreeNode deleteNode(TreeNode root, int key) {

        // If the tree is empty, there is nothing to delete
        if (root == null) {
            return null;
        }

        // If key is smaller than root value,
        // search in the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // If key is greater than root value,
        // search in the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // key == root.val
        // We have found the node that needs to be deleted
        else {

            // Case 1: Node has no left child
            // Replace it with its right child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: Node has no right child
            // Replace it with its left child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has two children

            // Find the smallest node in the right subtree
            // This is called the inorder successor
            TreeNode successor = findMin(root.right);

            // Copy the successor's value into the current node
            root.val = successor.val;

            // Delete the original successor node
            root.right = deleteNode(root.right, successor.val);
        }

        // Return the updated root
        return root;
    }

    // Finds the smallest node in a subtree
    private TreeNode findMin(TreeNode root) {

        // The smallest value in a BST is the leftmost node
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}