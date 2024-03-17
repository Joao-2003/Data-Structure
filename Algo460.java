import java.util.Scanner;

public class Algo460 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        for (int i = 1; i <= 3; i++){
            System.out.println("Digite um numero: ");
            num = scanner.nextInt();
            System.out.println("O dobro do numero é: " + dobro(num));
        }
    }

    private static int dobro(int num) {
        return num*2;
    }
}
