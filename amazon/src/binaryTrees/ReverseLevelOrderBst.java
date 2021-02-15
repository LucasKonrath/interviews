package binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

import binaryTrees.LevelOrderBst.TreeNode;

public class ReverseLevelOrderBst {

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

    public List<List<Integer>> reverseLevelOrder(ReverseLevelOrderBst.TreeNode root) {

        if(root == null){
            return Collections.emptyList();
        }

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> levelArray = new ArrayList<>();

        Queue<ReverseLevelOrderBst.TreeNode> currentNodeQueue = new ArrayDeque<>();
        currentNodeQueue.add(root);
        Queue<ReverseLevelOrderBst.TreeNode> nextNodesQueue = new ArrayDeque<>();

        while (!currentNodeQueue.isEmpty()){

            ReverseLevelOrderBst.TreeNode currentNode = currentNodeQueue.poll();
            levelArray.add(currentNode.val);

            if(currentNode.left != null){
                nextNodesQueue.add(currentNode.left);
            }

            if(currentNode.right != null){
                nextNodesQueue.add(currentNode.right);
            }

            if(currentNodeQueue.isEmpty()){
                results.add(levelArray);
                levelArray = new ArrayList<>();
                currentNodeQueue = nextNodesQueue;
                nextNodesQueue = new LinkedList<>();
            }
        }

        Collections.reverse(results);
        return results;
    }

    public static void main(String[] args) {
        ReverseLevelOrderBst levelOrderTraversal = new ReverseLevelOrderBst();
        System.out.println(levelOrderTraversal.reverseLevelOrder(
            new ReverseLevelOrderBst.TreeNode(
                3, new ReverseLevelOrderBst.TreeNode(9), new ReverseLevelOrderBst.TreeNode(20, new ReverseLevelOrderBst.TreeNode(15), new ReverseLevelOrderBst.TreeNode(7))
            )
        ));
    }
}
