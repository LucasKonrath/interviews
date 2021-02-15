package binaryTrees;

import java.util.Arrays;

public class SortedArrayToBST {

    public static class TreeNode {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int half = nums.length / 2;

        TreeNode rootNode = new TreeNode(nums[half]);

        int[] left = Arrays.copyOf(nums, nums.length / 2);
        System.out.println(left);

        rootNode.left = sortedArrayToBST(left);

        if(nums.length > 2){
            int[] right = Arrays.copyOfRange(nums, (nums.length/2) + 1, nums.length);
            rootNode.right = sortedArrayToBST(right);
        }

        return rootNode;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        SortedArrayToBST sortedArrayToBST =  new SortedArrayToBST();
        sortedArrayToBST.sortedArrayToBST(nums);
    }
}
