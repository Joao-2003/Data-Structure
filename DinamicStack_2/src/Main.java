import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte num;
        Scanner sc = new Scanner(System.in);
        DinamicStack even = new DinamicStack();
        DinamicStack odd = new DinamicStack();

        while(true){
            System.out.println("Digite um numero: ");
            num = sc.nextByte();
            if(num == 0){
                break;
            }
            if(isEnven(num)){
                even.push(num);
            } else{
                odd.push(num);
            }
        }

        while (true){
            odd.pop();
            if (odd.isEmpty()){
                break;
            }
            even.pop();
            if (even.isEmpty()){
                break;
            }
        }

        if (even.isEmpty()){
            System.out.println("A pilha de numeros impares ainda possui elementos.");
            System.out.println("Quantidade de elementos: " + odd.size());
            System.out.println("Elementos presentes: ");
            odd.print();
        } else {
            System.out.println("A pilha de numeros pares ainda possui elementos.");
            System.out.println("Quantidade de elementos: " + even.size());
            System.out.println("Elementos presentes: ");
            even.print();
        }
    }
    public static boolean isEnven(int num) {
        return num % 2 == 0;
    }
}