public class Main {
    public static void main(String[] args) {
        int[] vector1 = new int[1000];

        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = (int) (Math.random() * 100);
        }

        Search search = new Search();

        System.out.println(search.LinearSearch(vector1, 10));

    }
}