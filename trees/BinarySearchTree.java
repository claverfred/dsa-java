import java.util.Scanner;

public class BinarySearchTree{
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    public TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    TreeNode root;
    BinarySearchTree(){
        root = null;
    }

    public TreeNode insert(TreeNode root, int data){
        if(root == null){
            root = new TreeNode(data);
            return root;
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        }else{
            root.right = insert(root.right, data);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int data){
        if(root == null || root.data == data){
            return root;
        }
        if(root.data < data){
            return search(root.right, data);
        }
        return search(root.left, data);
    }
   

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
        
    }

    public void preorder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(TreeNode root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    //wrapper methods
    public void insertIntoTree(int data){
        root = insert(root, data);
    }

    public TreeNode searchInTree(int data){
        return search(root, data);
    }
    public void inorderTraversal(){
            inorder(root);
        }

        public void preorderTraversal(){
            preorder(root);
        }
    public void postorderTraversal(){
            postorder(root);
    }

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();

        int n, num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the tree: ");
        n = sc.nextInt();
        System.out.println("Enter "+n+" nodes of the tree: ");
        for(int i=0; i<n; i++){
            num = sc.nextInt();
            tree.insertIntoTree(num);
        }

        System.out.println("Tree insertion done!");
        System.out.println("Enter the number to be searched in the tree: ");

        num = sc.nextInt();

        if(tree.searchInTree(num) != null){
            System.out.println("The number "+num+" is present in the tree.");
        }else{
            System.out.println("The number "+num+" is not present in the tree.");
        }
        System.out.println("Inorder Traversal: ");
                tree.inorderTraversal();

                System.out.println();

        System.out.println("Preorder Traversal: ");
                tree.preorderTraversal();

                System.out.println();
        System.out.println("Postorder Traversal: ");
                tree.postorderTraversal();    
     }
}