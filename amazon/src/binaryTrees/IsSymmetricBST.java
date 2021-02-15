package binaryTrees;

public class IsSymmetricBST {

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

    public boolean isSymTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        } else if(p == null || q == null){
            return false;
        }

        return q.val == p.val && isSymTree(p.left, q.right) && isSymTree(p.right, q.left);
    }
}
