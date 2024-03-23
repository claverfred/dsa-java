import javax.swing.tree.TreeNode;

public class DiameterOfBinaryTree {
        int max = 0;
        private int diameter(TreeNode root) {
            max = 1;
            depth(root);
            return max - 1;
        }

        private int depth(TreeNode node)
        {
            if(node == null)
            {
                return 0;
            }
                
            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);

            // update the answer, because diameter of a  
            // tree is nothing but maximum value of  
            // (left_depth + right_depth + 1) for each node  
            max = Math.max(max, leftDepth + rightDepth + 1);
            return 1 + Math.max(leftDepth, rightDepth);        
    }
    
}
