package bai11_map_tree.baitap.product.binary_search_tree;

public class BinarySearchTree {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public BinarySearchTree(){
    }

    public void add(int data){
        if (root == null){
            root = new Node(data);
        } else {
            Node temp = root;
            while (true){
                if (temp.data > data){
                    if (temp.left == null) {
                        temp.left = new Node(data);
                        break;
                    }
                    else temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = new Node(data);
                        break;
                    }
                    else temp = temp.right;
                }
            }
        }
    }

    public void show(){
        postOrder(root);
    }

    public void postOrder(Node root){
        if (root != null){
            postOrder(root.left);
            System.out.print(root.data+"\t");
            postOrder(root.right);
        }
    }
}
