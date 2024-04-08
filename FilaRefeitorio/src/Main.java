import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Pessoa> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Adicionar pessoa à fila");
                System.out.println("2. Remover pessoa da fila");
                System.out.println("3. Visualizar fila");
                System.out.println("4. Sair");

                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        System.out.println("Quem você deseja adicionar?");
                        System.out.println("1. Aluno");
                        System.out.println("2. Professor");
                        System.out.println("3. Técnico");
                        System.out.print("Tipo: ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha

                        Pessoa pessoa = null;
                        switch (tipo) {
                            case 1:
                                System.out.print("Número de Matrícula: ");
                                String matricula = scanner.nextLine();
                                System.out.print("Nome: ");
                                String nomeAluno = scanner.nextLine();
                                System.out.print("Curso: ");
                                String curso = scanner.nextLine();
                                pessoa = new Aluno(matricula, nomeAluno, curso);
                                break;
                            case 2:
                                System.out.print("Número SIAPE: ");
                                String siape = scanner.nextLine();
                                System.out.print("Nome: ");
                                String nomeProfessor = scanner.nextLine();
                                System.out.print("Titulação: ");
                                String titulacao = scanner.nextLine();
                                pessoa = new Professor(siape, nomeProfessor, titulacao);
                                break;
                            case 3:
                                System.out.print("Número SIAPE: ");
                                String siapeTecnico = scanner.nextLine();
                                System.out.print("Nome: ");
                                String nomeTecnico = scanner.nextLine();
                                pessoa = new Tecnico(siapeTecnico, nomeTecnico);
                                break;
                            default:
                                System.out.println("Tipo inválido.");
                                break;
                        }

                        if (pessoa != null) {
                            fila.offer(pessoa);
                            System.out.println(pessoa.getNome() + " adicionado(a) à fila.");
                        }
                        break;
                    case 2:
                        Pessoa pessoaRemovida = fila.poll();
                        if (pessoaRemovida != null) {
                            System.out.println(pessoaRemovida.getNome() + " removido(a) da fila.");
                        } else {
                            System.out.println("A fila já está vazia.");
                        }
                        break;
                    case 3:
                        System.out.println("Fila atual:");
                        for (Pessoa p : fila) {
                            System.out.println(p);
                        }
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }
}
