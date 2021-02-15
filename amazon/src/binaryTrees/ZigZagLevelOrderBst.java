package binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderBst {

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

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> levelArray = new ArrayList<>();

        Queue<TreeNode> currentNodeQueue = new ArrayDeque<>();
        currentNodeQueue.add(root);
        Queue<TreeNode> nextNodesQueue = new ArrayDeque<>();

        boolean goingLeft = false;

        while (!currentNodeQueue.isEmpty()) {

            TreeNode currentNode = currentNodeQueue.poll();
            levelArray.add(currentNode.val);

            if (currentNode.left != null) {
                nextNodesQueue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                nextNodesQueue.add(currentNode.right);
            }

            if (currentNodeQueue.isEmpty()) {

                if (goingLeft) {
                    Collections.reverse(levelArray);
                }

                results.add(levelArray);
                levelArray = new ArrayList<>();
                currentNodeQueue = nextNodesQueue;
                nextNodesQueue = new LinkedList<>();
                goingLeft = !goingLeft;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        ZigZagLevelOrderBst levelOrderTraversal = new ZigZagLevelOrderBst();
        TreeNode _50 = new TreeNode(50);
        TreeNode _7 = new TreeNode(7);
        TreeNode _8 = new TreeNode(8);
        TreeNode _1 = new TreeNode(1);
        TreeNode _21 = new TreeNode(21);
        TreeNode _15 = new TreeNode(15);
        TreeNode _212 = new TreeNode(21);
        TreeNode _10 = new TreeNode(10);
        TreeNode _9 = new TreeNode(9);
        TreeNode _72 = new TreeNode(7);

        _50.left = _7;
        _50.right = _212;

        _7.left = _8;
        _8.left = _1;
        _8.right = _21;
        _21.left = _15;

        _212.left = _10;
        _212.right = _9;
        _10.right = _72;

        System.out.println(levelOrderTraversal.levelOrder(
            _50
        ));
    }
}
