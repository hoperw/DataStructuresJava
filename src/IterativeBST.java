import java.util.Objects;
import java.util.Stack;

public class IterativeBST implements BST<Node> {

    private Node root;

    IterativeBST() {
        this.root = null;
    }
    @Override
    public void addNode(Integer id, String data) {
        if (validData(id, data)) {
            if (root == null) {
                this.root = new Node(id, data);
            } else {
                Node current = root;
                Node prev = null;
                while (current != null) {
                    prev = current;
                    if (id > current.id) {
                        current = current.right;
                    } else {
                        current = current.left;
                    }
                }
                if (id > prev.id) {
                    prev.right = new Node(id, data);
                } else {
                    prev.left = new Node(id, data);
                }
            }
        }
    }
    @Override
    public void displayPreOrder() {
        if (this.root == null) {
            System.out.println("Tree is empty");
        } else {
            displayPreOrder(this.root);
        }
    }
    private void displayPreOrder(Node currentroot) {
        Stack<Node> stack = new Stack<>();
        // preOrder starts with the root, then left, then right
        stack.push(currentroot);
        System.out.println("Displaying preorder iteratively: \n");
        while (!stack.isEmpty()) {
            currentroot = stack.pop();
            System.out.println(currentroot.id);
            // add right node to the stack first because stack is FILO
            if (currentroot.right != null) {
                stack.push(currentroot.right);
            }
            if (currentroot.left != null) {
                stack.push(currentroot.left);
            }
        }
    }
    @Override
    public void displayInOrder() {

    }

    @Override
    public void displayPostOrder() {

    }
    private boolean validData(int id, String data) {
        return id > 0 && !Objects.equals(data, "");
    }
    @Override
    public boolean isEmpty() {
        return this.root == null;
    }
}
