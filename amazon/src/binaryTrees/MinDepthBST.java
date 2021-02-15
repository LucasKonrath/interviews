package binaryTrees;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinDepthBST {

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

    public int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        int minDepth = 0;
        Queue<TreeNode> nodesQueue = new ArrayDeque<>();

        nodesQueue.add(root);
        Queue<TreeNode> nextLevelNodes = new ArrayDeque<>();

        while (!nodesQueue.isEmpty()){

            TreeNode currentNode = nodesQueue.poll();

            if(isLeaf(currentNode)){
                return minDepth + 1;
            }

            if(currentNode.left != null){
                nextLevelNodes.add(currentNode.left);
            }

            if(currentNode.right != null){
                nextLevelNodes.add(currentNode.right);
            }

            if(nodesQueue.isEmpty()){
                minDepth++;
                nodesQueue = nextLevelNodes;
                nextLevelNodes = new ArrayDeque<>();
            }
        }

        return minDepth;
    }

    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

}
