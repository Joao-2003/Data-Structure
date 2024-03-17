import java.util.Scanner;

public class Algo480 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String num;

        System.out.println("Digite um numero: ");
        num = scanner.nextLine();

        if (cupicua(num)){
            System.out.println("Esse numero eh cupicua");
        } else{
            System.out.println("Esse numero nao eh cupicua");
        }
    }
    private static boolean cupicua(String num) {
        char[] inverse = new char[num.length()];
        for(int i = 0; i < num.length(); i++){
            inverse[i] = num.charAt(num.length()-1-i);
        }
        String inverso = new String(inverse);
        if (inverso.equals(num)){
            return true;
        }else{
            return false;
        }

    }
}
