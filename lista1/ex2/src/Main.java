import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] vector1 = new int[1000];

        List pos1 = new ArrayList<>();
        List pos2 = new ArrayList<>();

        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = ((int) (Math.random() * 100));
        }

        int[] vector2 = Arrays.stream(vector1).sorted().toArray();

        Search search = new Search();

        System.out.println(search.LinearSearch(vector1, 10, pos1));
        System.out.println(search.BinarySearch(vector2, 10, pos2));
    }
}