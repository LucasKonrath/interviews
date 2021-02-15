package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class InOrder {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        inOrder(root, results);
        return results;
    }

    public void inOrder(TreeNode node, ArrayList<Integer> results) {
        if (node == null) {
            return;
        }

        inOrder(node.left, results);
        results.add(node.val);
        inOrder(node.right, results);
    }
}
