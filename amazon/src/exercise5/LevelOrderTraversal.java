package exercise5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import sun.reflect.generics.tree.Tree;

public class LevelOrderTraversal {

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(final TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        final List<List<Integer>> resultArray = new ArrayList<>();
        List<Integer> levelValues = new ArrayList<>();

        Queue<TreeNode> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(root);

        while (nodesToVisit.size() > 0){
            Integer queueSize = nodesToVisit.size();
            Integer iterationCounter = 0;
            levelValues = new ArrayList<>();

            while (iterationCounter < queueSize){
                TreeNode currentNode = nodesToVisit.poll();
                levelValues.add(currentNode.val);

                if(currentNode.left != null){
                    nodesToVisit.add(currentNode.left);
                }

                if(currentNode.right != null){
                    nodesToVisit.add(currentNode.right);
                }

                    iterationCounter++;
            }

            resultArray.add(levelValues);
        }

        return resultArray;
    }


    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        System.out.println(levelOrderTraversal.levelOrder(
            new TreeNode(
                3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))
            )
        ));
    }
}
