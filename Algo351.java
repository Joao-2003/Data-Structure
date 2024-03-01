import java.util.Scanner;

public class Algo351 {
    public static void main(String[] args) {
        int num;
        String[] nomes = new String[5];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i <= 4; i++){
            System.out.println("Digite o " + (i+1) + "º nome\n");
            nomes[i] = scanner.nextLine();
        }
        System.out.println("Digite o numero da pessoa: \n");
        num = scanner.nextInt();
        while(num < 1 || num > 5){
            System.out.println("Numero fora do intervalo: \n");
            System.out.println("Digite o numero da pessoa: \n");
            num = scanner.nextInt();
        }
        System.out.println(nomes[num-1]);
    }
}
