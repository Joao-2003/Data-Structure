public class Main {
    public static void main(String[] args) {
        RedBlackTree rbtree = new RedBlackTree();
        rbtree.insert(50);
        System.out.println("Initial RB Tree with root 50:");
        rbtree.printTree();

        int[] elementsToInsert = {30, 20, 70, 40, 35, 37, 38, 10, 32, 45, 42, 25, 47, 36, 49};
        for (int element : elementsToInsert) {
            System.out.println("\nInserting " + element + ":");
            rbtree.insert(element);
            rbtree.printTree();

        }

        int[] elementsToRemove = {37, 70, 45, 36, 32, 42, 40};
        for (int element : elementsToRemove) {
            System.out.println("\nRemoving " + element + ":");
            rbtree.delete(element);
            rbtree.printTree();
        }
    }
}
