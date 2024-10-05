import java.util.List;

public class Search {
    public List<Integer> LinearSearch(int[] arr, int key, List<Integer> list) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> BinarySearch(int[] arr, int key, List<Integer> list) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                // Encontrar todas as ocorrências à esquerda
                int left = mid;
                while (left >= 0 && arr[left] == key) {
                    list.add(left);
                    left--;
                }
                // Encontrar todas as ocorrências à direita
                int right = mid + 1;
                while (right < arr.length && arr[right] == key) {
                    list.add(right);
                    right++;
                }
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            }
        }
        list.sort(null);
        return list;
    }
}
