package exercise6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import exercise5.LevelOrderTraversal;
import exercise6.DetermineBST.BinaryTree.TreeNode;

public class DetermineBST {

    public static class BinaryTree {
        public static class TreeNode {
            int data;
            TreeNode left, right;

            TreeNode(int value){
                this.data = value;
                left = right = null;
            }
        }

        TreeNode root;

        public boolean isBtree(){
            final Stack<Integer> integerStack = new Stack<>();
            try{
                inOrder(root, integerStack);
            } catch (Exception e){
                System.out.println(integerStack);
                return false;
            }

            System.out.println(integerStack);
            return true;
        }

        private void inOrder(TreeNode node, Stack<Integer> intStack){
            if(node == null)
                return;

            inOrder(node.left, intStack);

            if(!intStack.isEmpty() && node.data < intStack.peek()){
                throw new RuntimeException();
            }

            intStack.push(node.data);

            inOrder(node.right, intStack);

        }
    }

    public static BinaryTree create(){
        BinaryTree btree = new BinaryTree();
        TreeNode root = new TreeNode(40);
        btree.root = root;
        btree.root.left = new TreeNode(20);
        btree.root.left.left = new TreeNode(10);
        btree.root.left.left.left = new TreeNode(7);

        btree.root.left.right = new TreeNode(30);
        btree.root.right = new TreeNode(50);
        btree.root.right.right = new TreeNode(60);
        btree.root.right.right.right = new TreeNode(67);
        btree.root.right.right.right.right = new TreeNode(78);
        return btree;
    }

    public static void main(String[] args) {
        BinaryTree tree = create();

        System.out.println(tree.isBtree());
    }

}
