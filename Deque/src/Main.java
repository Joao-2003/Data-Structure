import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Criando os deques
        Deque deque1 = new Deque();
        Deque deque2 = new Deque();

        Random random = new Random();

        int groupSize = 1;
        int totalAttended = 0;
        int id = 0;

        while (totalAttended < 100) {
            for (int i = 1; i <= 10; i++) {
                // Criando uma pessoa aleatória
                boolean isMale = random.nextBoolean();
                int age = random.nextInt(120);
                boolean isPregnant = random.nextBoolean();
                boolean isLactating = random.nextBoolean();
                boolean hasSpecialNeeds = random.nextBoolean();

                Person person = new Person(id, age, isMale, isPregnant, isLactating, hasSpecialNeeds);

                // Inserindo a pessoa no deque apropriado
                if (person.priority == 3) {
                    deque1.insertLast(person);
                } else {
                    deque2.insertLast(person);
                }
                id++;
            }

            System.out.print("Grupo " + groupSize + ": ");
            for (int i = 0; i < groupSize; i++) {
                if (totalAttended < 100) {
                    try {
                        // Tentando pegar do deque1
                        Person nextPerson = deque1.removeFirst();
                        System.out.print("Pessoa " + nextPerson.id + " (Prioridade " + nextPerson.priority + ") ");
                    } catch (NullPointerException e) {
                        // Se deque1 estiver vazio, pegar do deque2
                        Person nextPerson = deque2.removeFirst();
                        System.out.print("Pessoa " + nextPerson.id + " (Prioridade " + nextPerson.priority + ") ");
                    }
                    totalAttended++;
                }
            }
            System.out.println();
            groupSize++;
        }

        // Exibindo as pessoas não atendidas
        int notAttended = id - totalAttended;
        System.out.println("Total de pessoas atendidas: " + totalAttended);
        System.out.println("Pessoas não atendidas: " + notAttended);
        deque1.print();
        deque2.print();
    }
}
