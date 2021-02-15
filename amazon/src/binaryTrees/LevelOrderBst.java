package binaryTrees;

import static java.util.Objects.nonNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import exercise5.LevelOrderTraversal;
import exercise5.LevelOrderTraversal.TreeNode;
import sun.reflect.generics.tree.Tree;

public class LevelOrderBst {

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

        if(root == null){
            return Collections.emptyList();
        }

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> levelArray = new ArrayList<>();

        Queue<TreeNode> currentNodeQueue = new ArrayDeque<>();
        currentNodeQueue.add(root);
        Queue<TreeNode> nextNodesQueue = new ArrayDeque<>();

        while (!currentNodeQueue.isEmpty()){

            TreeNode currentNode = currentNodeQueue.poll();
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

        return results;
    }

    public static void main(String[] args) {
        LevelOrderBst levelOrderTraversal = new LevelOrderBst();
        System.out.println(levelOrderTraversal.levelOrder(
            new LevelOrderBst.TreeNode(
                3, new LevelOrderBst.TreeNode(9), new LevelOrderBst.TreeNode(20, new LevelOrderBst.TreeNode(15), new LevelOrderBst.TreeNode(7))
            )
        ));
    }
}
