import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class HeightOfBinaryTree {
    public class Node {
        private int value;
        private Node left;
        private Node right;
       
    
        public Node(int value) {
          this.value = value;
        }
    
        public int getValue() {
          return value;
        }
      }
    
      private Node root;

     private int heightOfBinaryTreeRecursive(Node root)
{
    // Initialize 2 variables for left and right height
    int leftHeight;
    int rightHeight;
     
    // The terminating case
    if(root == null)
        return 0;
    else
    {
        // Find the depth of left sub-tree
        leftHeight = heightOfBinaryTreeRecursive(root.left);
         
        // Find the depth of right sub-tree
        rightHeight = heightOfBinaryTreeRecursive(root.right);
         
        // Compare the two heights and return the larger of two + 1
        if(leftHeight > rightHeight)
        {
            // Return the leftHeight + 1
            return (leftHeight + 1);
        }
        else
        {
            // Return the rightHeight + 1
            return (rightHeight + 1);
        }
        }
    }


    //==========================================
    //another solution
    public int heightOfBinaryTree(Node root){
        if (root == null)
        return 0;

        Queue<TreeNode> nodes = new LinkedList<>();

        nodes.add(root);
        int levels = 0;

        while (!nodes.isEmpty()) {

        levels++;
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            TreeNode poppedNode = nodes.poll();
            if (poppedNode.left != null) nodes.add(poppedNode.left);
            if (poppedNode.right != null) nodes.add(poppedNode.right);
        }

        }

        return levels;
        }
}
