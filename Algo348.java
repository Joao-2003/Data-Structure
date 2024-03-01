import java.util.Scanner;

public class Algo348 {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        float[] pr1 = new float[5], pr2 = new float[5] , medias = new float[5];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i <= 4; i++){
            System.out.println("Digite o " + (i+1) +"º nome:\n");
            nomes[i] = scanner.nextLine();
            System.out.println("Digite a 1ª nota do aluno " + nomes[i] + " :\n");
            pr1[i] = scanner.nextFloat();
            System.out.println("Digite a 2ª nota do aluno " + nomes[i] + " :\n");
            pr2[i] = scanner.nextFloat();
            medias[i] = (pr1[i] + pr2[i])/2;
            scanner.nextLine();
        }

        for(int i = 0; i <= 4; i++){
            System.out.println("Nome: \n" + nomes[i]);
            System.out.println("Notas: \n" + pr1[i] + " e " + pr2[i]);
            System.out.println("Media: \n" + medias[i] + "\n");
        }
    }
}
