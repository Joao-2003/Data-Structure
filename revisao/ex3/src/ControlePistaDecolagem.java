import java.util.LinkedList;
import java.util.Queue;
public class ControlePistaDecolagem {
    private Queue<Aviao> filaDecolagem = new LinkedList<>();

    public void listarNumeroAvioes() {
        System.out.println("Número de aviões aguardando na fila de decolagem: " + filaDecolagem.size());
    }

    public void autorizarDecolagem() {
        if (filaDecolagem.isEmpty()) {
            System.out.println("Não há aviões na fila de decolagem.");
        } else {
            Aviao aviao = filaDecolagem.poll();
            System.out.println("Decolagem autorizada para: " + aviao);
        }
    }

    public void adicionarAviao(String nome, int identificador) {
        Aviao aviao = new Aviao(nome, identificador);
        filaDecolagem.add(aviao);
        System.out.println("Avião adicionado à fila de decolagem: " + aviao);
    }

    public void listarAvioes() {
        if (filaDecolagem.isEmpty()) {
            System.out.println("Não há aviões na fila de decolagem.");
        } else {
            System.out.println("Aviões na fila de decolagem:");
            for (Aviao aviao : filaDecolagem) {
                System.out.println(aviao);
            }
        }
    }

    public void listarPrimeiroAviao() {
        if (filaDecolagem.isEmpty()) {
            System.out.println("Não há aviões na fila de decolagem.");
        } else {
            Aviao aviao = filaDecolagem.peek();
            System.out.println("Primeiro avião na fila de decolagem: " + aviao);
        }
    }
}
