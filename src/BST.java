import java.util.Objects;

public class BST {

    private Node root;

    BST() {
        this.root = null;
    }

    public void addNode(int id, String data) {
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

    public void addNodeRecursive(int id, String data) {
        this.root = addNodeRecursive(this.root, id, data);
    }
    private Node addNodeRecursive(Node temproot, int id, String data) {
        if (validData(id, data)) {
            if (temproot == null) {
                return new Node(id, data);
            }
            if (id > temproot.id) {
                temproot.right = addNodeRecursive(temproot.right, id, data);
            } else {
                temproot.left = addNodeRecursive(temproot.left, id, data);
            }
        }
        return temproot;
    }
    public void displayInOrder() {
        if (this.root != null) {
            System.out.println("Display in order: " );
            displayInOrder(this.root);
        } else {
            System.out.println("Tree is empty");
        }
    }
    private void displayInOrder(Node temproot) {
        if (temproot != null) {
            displayInOrder(temproot.left);
            System.out.println("ID: " + temproot.id + " Data: " + temproot.data + "\n");
            displayInOrder(temproot.right);
        }
    }
    private boolean validData(int id, String data) {
        return id > 0 && !Objects.equals(data, "");
    }

}
