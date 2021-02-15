package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {

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

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        postOrder(root, results);
        return results;
    }

    public void postOrder(TreeNode node, ArrayList<Integer> results) {
        if (node == null) {
            return;
        }

        postOrder(node.left, results);
        postOrder(node.right, results);
        results.add(node.val);
    }
}
