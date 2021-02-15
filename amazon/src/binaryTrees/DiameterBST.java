package binaryTrees;

import java.util.ArrayList;
import java.util.List;

import binaryTrees.MaxDepthBST.TreeNode;

public class DiameterBST {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int getHeight(TreeNode root) {
        if(root == null) return  0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public int diameterOfBinaryTree(TreeNode node) {
        if(node == null){
            return 0;
        }
        int option1 = getHeight(node.left) + getHeight(node.right);
        int option2 = diameterOfBinaryTree(node.left);
        int option3 = diameterOfBinaryTree(node.right);
        return Math.max(option1, Math.max(option2, option3));
    }
}
