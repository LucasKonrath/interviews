package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        preOrder(root, results);
        return results;
    }

    public void preOrder(TreeNode node, ArrayList<Integer> results) {
        if (node == null) {
            return;
        }

        results.add(node.val);
        preOrder(node.left, results);
        preOrder(node.right, results);
    }
}
