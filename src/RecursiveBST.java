import java.util.Objects;

public class RecursiveBST implements BST<Node> {

    private Node root;

    RecursiveBST() {
        this.root = null;
    }
    @Override
    public void addNode(Integer id, String data) {
        this.root = addNode(this.root, id, data, false);
    }
    private Node addNode(Node currentroot, int id, String data, boolean added) {
        if (validData(id, data) && added == false) {
            if (currentroot == null) {
                currentroot = new Node(id, data);
                added = true;
            }
            if (id > currentroot.id) {
                currentroot.right = addNode(currentroot.right, id, data, added);
            } else if(currentroot!= null) {
                currentroot.left = addNode(currentroot.left, id, data, added);
            }
        }
        return currentroot;
    }
    public void displayInOrder() {
        if (this.root != null) {
            System.out.println("Display in order: " );
            displayInOrder(this.root);
        } else {
            System.out.println("Tree is empty");
        }
    }
    private void displayInOrder(Node currentroot) {
        if (currentroot != null) {
            displayInOrder(currentroot.left);
            System.out.println("ID: " + currentroot.id + " Data: " + currentroot.data + "\n");
            displayInOrder(currentroot.right);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }
    public void displayPreOrder() {
        if (this.root != null) {
            System.out.println("Display in preorder: ");
            displayPreOrder(this.root);
        } else {
            System.out.println("Tree is empty");
        }
    }
    private void displayPreOrder(Node currentroot) {
        if (currentroot != null) {
            System.out.println("ID: " + currentroot.id + " Data: " + currentroot.data + "\n");
            displayPreOrder(currentroot.left);
            displayPreOrder(currentroot.right);
        }
    }
    public void displayPostOrder() {
        if (this.root != null) {
            System.out.println("Display in postorder: ");
            displayPreOrder(this.root);
        } else {
            System.out.println("Tree is empty");
        }
    }
    private void displayPostOrder(Node currentroot) {
        if (currentroot != null) {
            displayPreOrder(currentroot.left);
            displayPreOrder(currentroot.right);
            System.out.println("ID: " + currentroot.id + " Data: " + currentroot.data + "\n");
        }

    }
    private boolean validData(Integer id, String data) {
        return id > 0 && !Objects.equals(data, "");
    }

}
