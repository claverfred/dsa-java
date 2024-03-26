import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
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
     public TreeNode invertTreeRecursiveSolution(TreeNode root) {
        if(root == null)
        return null;
        TreeNode left = invertTreeRecursiveSolution(root.left);
        TreeNode right = invertTreeRecursiveSolution(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    TreeNode invertTreeIterativeSolution(TreeNode root){
        if(root == null){
            return null;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            final TreeNode node = queue.poll();

            //swap nodes
            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            //add left and right nodes to queue
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return root;
    }
}
