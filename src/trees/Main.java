package trees;

public class Main {
    public static void main(String[] args) {
        bst binaryTree = new bst();

        binaryTree.insert(2);
        binaryTree.insert(9);
        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(21);

        binaryTree.inOrderPrint();
    }
}
