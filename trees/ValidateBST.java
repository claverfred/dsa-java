import javax.swing.tree.TreeNode;

public class ValidateBST {

      //  Definition for a binary tree node.
      public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }


    public boolean isValidBST(TreeNode root) {
        return BST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean BST(TreeNode root,int min, int max){
        if(root == null) return true;
        if(root.val<= min || root.val>= max) return false;
        return BST(root.left,min,root.val) && BST(root.right,root.val,max);
    }
}
