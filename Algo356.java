import java.util.Scanner;

public class Algo356 {
    public static void main(String[] args) {
        String[] nomes = new String[15], sit = new String[15];
        double[] pr1 = new double[15], pr2 = new double[15] , medias = new double[15];
        int t;
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i <= 14; i++){
            System.out.println("Digite o " + (i+1) +"º nome:\n");
            nomes[i] = scanner.nextLine();

            while(nomes[i].length()>30){
                System.out.println("Nomes com ate 30 caracteres.\n");
                System.out.println("Digite o " + (i+1) +"º nome:\n");
                nomes[i] = scanner.nextLine();
            }
            t = 30 - nomes[i].length();
            for(int c = -1; c <= t; c++){
                nomes[i] = nomes[i].concat(" ");
            }
            System.out.println("Digite a 1ª nota do aluno " + nomes[i] + " :\n");
            pr1[i] = scanner.nextFloat();
            System.out.println("Digite a 2ª nota do aluno " + nomes[i] + " :\n");
            pr2[i] = scanner.nextFloat();
            medias[i] = (pr1[i] + pr2[i])/(2+0.0001);
            if(medias[i] >= 5){
                sit[i] = "AP";
            } else{
                sit[i] = "RP";
            }
            scanner.nextLine();
        }

        for(int i = 0; i <= 14; i++){
            System.out.println("Nome: \n" + nomes[i]);
            System.out.println("Notas: \n" + pr1[i] + " e " + pr2[i]);
            System.out.println("Media: \n" + medias[i]);
            System.out.println("Situacao: \n" + sit[i]);
        }
    }
}
