import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DinamicStack stack = new DinamicStack();
        String string = sc.nextLine();
        for (char c : string.toCharArray()) {
            if (c == '('){
                stack.push(Character.toString(c));
            } else if (c == ')' && stack.peek().equals("(")){
                stack.pop();
            } else if (c == '['){
                stack.push(Character.toString(c));
            } else if (c == ']' && stack.peek().equals("[")){
                stack.pop();
            } else if (c == '{'){
                stack.push(Character.toString(c));
            } else if (c == '}' && stack.peek().equals("{")){
                stack.pop();
            }
        }
        if (stack.isEmpty()){
            System.out.println("Correto");
        } else {
            System.out.println("Incorreto");
        }
    }
}