import java.util.LinkedList;
import java.util.Random;

class Josephus {
    LinkedList<Pessoa> pessoas;
    Random random;

    public Josephus(LinkedList<Pessoa> pessoas) {
        this.pessoas = new LinkedList<>(pessoas);
        this.random = new Random();
    }

    public Pessoa eliminaPessoa() {
        int m = random.nextInt(100);
        int i = 0;
        while (pessoas.size() > 1) {
            i = (i + m) % pessoas.size();
            //Pessoa pessoaEliminada = pessoas.get(index);
            // Remove a pessoa da lista
            pessoas.remove(i);

        }

        return pessoas.peek();
    }
}
