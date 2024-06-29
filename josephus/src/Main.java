import java.util.LinkedList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        LinkedList<Pessoa> pessoas = new LinkedList<>();
        for (int i = 1; i <= 20; i++) {
            Pessoa pessoa = new Pessoa("pessoa " + i, "telefone " + i, "endereco " + i, "cpf " + i);
            pessoas.add(pessoa);
        }
        Josephus josephus = new Josephus(pessoas);

        Pessoa ultimaPessoaRemovida = josephus.eliminaPessoa();
        System.out.println("Quem sobreviveu foi a " + ultimaPessoaRemovida.nome);
    }
}