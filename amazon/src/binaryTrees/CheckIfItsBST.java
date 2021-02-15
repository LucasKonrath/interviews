package binaryTrees;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class CheckIfItsBST {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class MyBooleanChecker {
        public boolean isBST = true;
    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        MyBooleanChecker myBooleanChecker = new MyBooleanChecker();

        Stack<Integer> values = new Stack<>();
        inOrder(root, values, myBooleanChecker);
        return myBooleanChecker.isBST;
    }

    public void inOrder(TreeNode node, Stack<Integer> values, MyBooleanChecker isBST) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            inOrder(node.left, values, isBST);
        }

        if (values.isEmpty()) {
            values.add(node.val);
        } else if (node.val > values.peek()) {
            values.add(node.val);
        } else {
            isBST.isBST = false;
            return;
        }

        if (node.right != null) {
            inOrder(node.right, values, isBST);
        }
    }

    public static void main(String[] args) {
        CheckIfItsBST checkBST = new CheckIfItsBST();
        /*
        Original tree    5
                      /      \
                     1       4
                            /  \
                           3   6
         */
        boolean valid = checkBST.isValidBST(
            new CheckIfItsBST.TreeNode(
                5, new CheckIfItsBST.TreeNode(1),
                new CheckIfItsBST.TreeNode(4, new CheckIfItsBST.TreeNode(3), new CheckIfItsBST.TreeNode(6))
            )
        );
        System.out.println(valid);
    }
}
