package binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBst {

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

    public TreeNode invert(TreeNode root) {

        if(root == null){
            return null;
        }

        TreeNode tempLeft = root.left;

        root.left = root.right;
        root.right = tempLeft;

        invert(root.left);
        invert(root.right);

        return root;
    }

    public static void main(String[] args) {
        InvertBst invertBst = new InvertBst();
        /*
        Original tree    1         Inverted Tree  1
                      /      \                  /   \
                     2       3                 3      2
                   /   \    /  \             /   \   / \
                  4    5   6   7            7    6  5   4
         */
        TreeNode inverted = invertBst.invert(
            new InvertBst.TreeNode(
                1, new InvertBst.TreeNode(2, new InvertBst.TreeNode(4), new InvertBst.TreeNode(5)), new InvertBst.TreeNode(3, new InvertBst.TreeNode(6), new InvertBst.TreeNode(7))
            )
        );
        System.out.println(inverted);
    }
}
