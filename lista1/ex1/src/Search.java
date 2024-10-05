public class Search {
    public static int LinearSearch(int[] arr, int key) {
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == key) {
//                return i;
//            }
//        }
//        return -1;
        int i = 0;
        while (i < arr.length){
            if (arr[i] == key) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
