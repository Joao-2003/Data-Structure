import java.util.Scanner;
import java.util.stream.IntStream;

public class Algo470 {
    public static void main(String[] args){
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero para descobrir se é primo: ");
        num = scanner.nextInt();
        if(verificaPrimo(num)){
            System.out.println("O numero eh primo");
        } else{
            System.out.println("O numero nao eh primo");
        }
    }
    public static boolean verificaPrimo(int num){
        boolean b = IntStream.range(2, num-1).noneMatch(i -> num % i == 0);
        return b;
    }
}
