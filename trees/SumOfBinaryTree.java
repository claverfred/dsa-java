public class SumOfBinaryTree {
    //sum of binary tree
    public class Node {
        private int data;
        private Node left;
        private Node right;
       
    
        public Node(int value) {
          this.data = value;
        }
    
        public int getValue() {
          return data;
        }
      }
    
      private Node root;

      public int sumOfBinaryTree(Node root) {
          // Terminating condition
        if(root == null)
        {
            return 0;
        }
        else
        {
            //Recursively call the addition of root + left + right
            return (root.data + sumOfBinaryTree(root.left) + sumOfBinaryTree(root.right));
        }
      }
    
}
