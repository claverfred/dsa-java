import java.util.Stack;

public class PathSumBT {
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
     public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
        return false;

        //create two stacks for the path and the sums
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> pathSum = new Stack<>();

        path.push(root);
        pathSum.push(root.val);

        while(!path.isEmpty()){
            TreeNode temp = path.pop();
            int tempVal = pathSum.pop();

            //if it is a leaf node and we find the sum return true
            if(temp.left == null && temp.right == null && tempVal == targetSum)
            return true;
            if(temp.right != null){
                path.push(temp.right);
                pathSum.push(temp.right.val + tempVal);
            }
            if(temp.left != null){
                path.push(temp.left);
                pathSum.push(temp.left.val + tempVal);
            }
        }
        return false;
    }
}
