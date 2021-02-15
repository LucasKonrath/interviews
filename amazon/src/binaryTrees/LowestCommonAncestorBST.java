package binaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestorBST {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p == null || q == null)
            return null;

        if(root ==  p || root == q)
            return root;

        Stack<TreeNode> valuestTillP = new Stack<>();
        findNode(root, p, valuestTillP);
        Stack<TreeNode> valuesTillQ = new Stack<>();
        findNode(root, p, valuesTillQ);
        System.out.println(valuesTillQ);

        return findLastMatch(valuesTillQ, valuestTillP);
    }

    private TreeNode findLastMatch(final Stack<TreeNode> valuesTillQ, final Stack<TreeNode> valuestTillP) {
        while(!valuesTillQ.isEmpty()){
            TreeNode lastNode = valuesTillQ.pop();
            if(valuestTillP.contains(lastNode)){
                return lastNode;
            }
        }

        return null;
    }

    public void findNode(TreeNode currentNode, TreeNode targetNode, Stack<TreeNode> visitedNodes){

        if(currentNode == null){
            return;
        }

        visitedNodes.add(currentNode);

        if(currentNode == targetNode) {
            return;
        }

        if(currentNode.val < targetNode.val){
            findNode(currentNode.right, targetNode, visitedNodes);
        } else {
            findNode(currentNode.left, targetNode, visitedNodes);
        }
    }

}
