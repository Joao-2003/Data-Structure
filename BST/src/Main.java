public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(50);
        System.out.println("Initial AVL Tree with root 50:");
        avlTree.printTree();

        int[] elementsToInsert = {1, 64, 12, 18, 66, 38, 95, 58, 59, 70, 68, 39, 62, 7, 60, 43, 16, 67, 34, 35};
        for (int element : elementsToInsert) {
            System.out.println("\nInserting " + element + ":");
            avlTree.insert(element);
            avlTree.printTree();
            avlTree.printBalanceFactors();
        }

        int[] elementsToRemove = {50, 95, 70, 60, 35};
        for (int element : elementsToRemove) {
            System.out.println("\nRemoving " + element + ":");
            avlTree.delete(element);
            avlTree.printTree();
            avlTree.printBalanceFactors();
        }
    }
}