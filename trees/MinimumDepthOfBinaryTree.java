import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
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
     public int minDepth(TreeNode root) {
        if(root == null)
        return 0;

        int depth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        //Level order traversal
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                //if a leaf node is found return depth
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            depth ++;
        }
        return depth;
    }
}
