public class Main {
    public static void main(String[] args) {
        // 1. Criação de Árvores
        System.out.println("=== CRIAÇÃO DE ÁRVORES ===");
        BST tree1 = new BST();
        tree1.insert(new Node(5));
        tree1.insert(new Node(3));
        tree1.insert(new Node(7));
        System.out.print("Tree1 (inorder): ");
        tree1.inorder();

        BST tree2 = new BST();
        tree2.insert(new Node(10));
        tree2.insert(new Node(5));
        System.out.print("Tree2 (inorder): ");
        tree2.inorder();

        BST tree3 = tree1.copyTree();
        tree3.insert(new Node(6));
        tree3.insert(new Node(8));
        System.out.print("Tree3 (inorder): ");
        tree3.inorder();

        BST tree4 = new BST();
        tree4.insert(new Node(6));
        tree4.insert(new Node(4));
        tree4.insert(new Node(8));
        System.out.print("Tree4 (inorder): ");
        tree4.inorder();

        // 2. Testes de Estrutura
        System.out.println("\n=== TESTES DE ESTRUTURA ===");
        System.out.println("Tree1 é estritamente binária? " + tree1.strictlyBinary());
        System.out.println("Tree2 é estritamente binária? " + tree2.strictlyBinary());
        System.out.println("Tree1 e Tree2 são semelhantes? " + tree1.alike(tree2));
        System.out.println("Tree1 e Tree4 são iguais? " + tree1.equals(tree4));
        System.out.println("Tree1 e Tree3 são iguais? " + tree1.equals(tree3));
        System.out.println("Tree1 e Tree4 são semelhantes? " + tree1.alike(tree4));

        // 3. Testes de Exclusão
        System.out.println("\n=== TESTES DE EXCLUSÃO ===");
        System.out.println("Excluindo o nó 7 de Tree3...");
        Node deleted7 = tree3.delete(7);
        System.out.println(deleted7.toString());
        System.out.print("Tree3 após exclusão (inorder): ");
        tree3.inorder();

        System.out.println("Excluindo o nó 6 de Tree4...");
        Node deleted6 = tree4.delete(6);
        System.out.println(deleted7.toString());
        System.out.print("Tree4 após exclusão (inorder): ");
        tree4.inorder();

        // 4. Testes de Busca
        System.out.println("\n=== TESTES DE BUSCA ===");
        System.out.println("Tree1 contém o elemento 3? " + tree1.search(3));
        System.out.println("Tree2 contém o elemento 3? " + tree2.search(3));
        System.out.println("Tree3 contém o elemento 3? " + tree3.search(3));
        System.out.println("Tree4 contém o elemento 3? " + tree4.search(3));

        // 5. Altura das Árvores
        System.out.println("\n=== ALTURA DAS ÁRVORES ===");
        System.out.println("Altura de Tree1: " + tree1.height());
        System.out.println("Altura de Tree2: " + tree2.height());
        System.out.println("Altura de Tree3: " + tree3.height());
        System.out.println("Altura de Tree4: " + tree4.height());

        // 6. Contagem de Nós e Folhas
        System.out.println("\n=== CONTAGEM DE NÓS E FOLHAS ===");
        System.out.println("Total de nós em Tree1: " + tree1.countNodes());
        System.out.println("Total de folhas em Tree1: " + tree1.countLeaves());

        System.out.println("Total de nós em Tree2: " + tree2.countNodes());
        System.out.println("Total de folhas em Tree2: " + tree2.countLeaves());

        // 7. Inserção Iterativa
        System.out.println("\n=== INSERÇÃO ITERATIVA ===");
        tree1.iterativeInsert(new Node(1));
        System.out.print("Tree1 após inserção de 1 (inorder): ");
        tree1.inorder();

        // 8. Espelhamento
        System.out.println("\n=== ESPELHAMENTO ===");
        BST mirror1 = tree1.mirror();
        System.out.print("Mirror de Tree1 (inorder): ");
        mirror1.inorder();

        BST mirror2 = tree2.mirror();
        System.out.print("Mirror de Tree2 (inorder): ");
        mirror2.inorder();
    }
}
