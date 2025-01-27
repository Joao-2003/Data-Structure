import java.util.Stack;

public class RedBlackTree {
    private Node root;
    private final Node TNULL; // Nó nulo externo (folhas)

    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = false; // Nó TNULL é sempre preto
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    // Rotação para a esquerda
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Rotação para a direita
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Balancear após a inserção
    private void fixInsert(Node k) {
        while (k.parent.color) { // Enquanto o pai for vermelho
            if (k.parent == k.parent.parent.right) {
                Node u = k.parent.parent.left; // Tio
                if (u.color) { // Caso 1: Tio é vermelho
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) { // Caso 2: Nó é filho à esquerda
                        k = k.parent;
                        rightRotate(k);
                    }
                    // Caso 3: Nó é filho à direita
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    leftRotate(k.parent.parent);
                }
            } else {
                Node u = k.parent.parent.right; // Tio
                if (u.color) { // Caso 1: Tio é vermelho
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) { // Caso 2: Nó é filho à direita
                        k = k.parent;
                        leftRotate(k);
                    }
                    // Caso 3: Nó é filho à esquerda
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = false; // A raiz deve ser sempre preta
    }

    // Inserção
    public void insert(int key) {
        Node node = new Node(key);
        node.parent = null;
        node.left = TNULL;
        node.right = TNULL;

        Node y = null;
        Node x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = false;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    // Balancear após a remoção
    private void fixDelete(Node x) {
        while (x != root && !x.color) {
            if (x == x.parent.left) {
                Node s = x.parent.right;
                if (s.color) { // Caso 1: O irmão é vermelho
                    s.color = false;
                    x.parent.color = true;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }
                if (!s.left.color && !s.right.color) { // Caso 2: Ambos os filhos do irmão são pretos
                    s.color = true;
                    x = x.parent;
                } else {
                    if (!s.right.color) { // Caso 3: O filho direito do irmão é preto
                        s.left.color = false;
                        s.color = true;
                        rightRotate(s);
                        s = x.parent.right;
                    }
                    // Caso 4: O filho direito do irmão é vermelho
                    s.color = x.parent.color;
                    x.parent.color = false;
                    s.right.color = false;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                Node s = x.parent.left;
                if (s.color) { // Caso 1: O irmão é vermelho
                    s.color = false;
                    x.parent.color = true;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }
                if (!s.left.color && !s.right.color) { // Caso 2: Ambos os filhos do irmão são pretos
                    s.color = true;
                    x = x.parent;
                } else {
                    if (!s.left.color) { // Caso 3: O filho esquerdo do irmão é preto
                        s.right.color = false;
                        s.color = true;
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    // Caso 4: O filho esquerdo do irmão é vermelho
                    s.color = x.parent.color;
                    x.parent.color = false;
                    s.left.color = false;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = false;
    }

    // Substituir nós
    private void transplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    // Mínimo de uma subárvore
    private Node minimum(Node node) {
        while (node.left != TNULL) {
            node = node.left;
        }
        return node;
    }

    // Remoção
    public Node delete(int key) {
        Node z = root;
        Node x, y;

        while (z != TNULL) {
            if (z.data == key) {
                break;
            }
            if (key < z.data) {
                z = z.left;
            } else {
                z = z.right;
            }
        }

        if (z == TNULL) {
            System.out.println("Chave não encontrada na árvore.");
            return z;
        }

        y = z;
        boolean yOriginalColor = y.color;
        if (z.left == TNULL) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (!yOriginalColor) {
            fixDelete(x);
        }
        return z;
    }

    // Imprimir em ordem
    public void inOrder() {
        inOrderHelper(root);
        System.out.println();
    }

    private void inOrderHelper(Node node) {
        if (node != TNULL) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    public void printTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int gaps = 96;
        boolean isRowEmpty = false;
        String separator = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }
}
