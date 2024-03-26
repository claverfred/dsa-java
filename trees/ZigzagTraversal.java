import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigzagTraversal {

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


     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean reverse = false;
    
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);
      for (int i=0; i < levelSize; i++) {
        if (!reverse) {
          TreeNode currentNode = queue.pollFirst();
          currentLevel.add(currentNode.val);
          if (currentNode.left != null) {
            queue.addLast(currentNode.left);
          }
          if (currentNode.right != null) {
            queue.addLast(currentNode.right);
          }
        } else {
          TreeNode currentNode = queue.pollLast();
          currentLevel.add(currentNode.val);
          if (currentNode.right != null) {
            queue.addFirst(currentNode.right);
          }
          if (currentNode.left != null) {
            queue.addFirst(currentNode.left);
          }
        }
      }
      reverse = !reverse;
      result.add(currentLevel);
    }
    return result;
    }

    public List<List<Integer>> zigzagLevelOrderSolution2(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();

        if (root == null) {
            return zigzag;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false; 
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<Integer> reverseStack = new Stack<>();

            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();
                if(reverse){
                    reverseStack.push(currentNode.val);
                }
                else{
                    level.add(currentNode.val);
                }
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            reverse = !reverse;
            //pop all elements from stack
            while(!reverseStack.isEmpty()){
                level.add(reverseStack.pop());
                zigzag.add(level);
            }
        }
        return zigzag;
   }
}
