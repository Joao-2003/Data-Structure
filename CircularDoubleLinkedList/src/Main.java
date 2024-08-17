import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] vector = new int[1000];
        Random random = new Random();
        ArrayList<Integer> removed = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            vector[i] = random.nextInt(-9999,9999);
        }
        System.out.println(Arrays.toString(vector));

        CircularDoubleLinkedList list = new CircularDoubleLinkedList();

        list.addToHead(vector[0]);
        for (int i = 1; i < 1000; i++) {
            if (vector[i] < list.sentinel.next.data){
                list.addToHead(vector[i]);
            } else if (vector[i] > list.sentinel.previous.data){
                list.addToTail(vector[i]);
            } else {
                list.insert(vector[i]);
            }
        }

        list.printIncreasing();
        list.printDecreasing();
        System.out.println(list.size());

        Node node = list.sentinel.next;
        for (int i = 0; i < 1000; i++) {
            if (isPrime(node.data)){
                removed.add(node.data);
                list.delete(i);
            }
            node = node.next;
        }
        list.printIncreasing();
        System.out.println(list.size());
        System.out.println(removed);
        System.out.println(removed.size());
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
