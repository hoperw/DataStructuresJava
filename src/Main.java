public class Main {

    public static void main(String[] args) {

        RecursiveBST tree = new RecursiveBST();

//        tree.addNode(4, "data");
//        tree.addNode(3, "data");
//        tree.addNode(2, "data");
//        tree.addNode(6, "data");
//        tree.addNode(5, "data");
//        tree.addNode(9, "data");

        tree.addNodeRecursive(4, "data");
        tree.addNodeRecursive(3, "data");
        tree.addNodeRecursive(2, "data");
        tree.addNodeRecursive(6, "data");
        tree.addNodeRecursive(5, "data");
        tree.addNodeRecursive(9, "data");


        //tree.displayPreOrder();
        tree.displayPreOrderItr();

    }
}
