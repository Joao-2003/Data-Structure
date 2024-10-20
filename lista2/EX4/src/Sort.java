public class Sort {

    public void bestBubbleSort(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    flag = 1;
                    int aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
            if (flag == 0) {
                return;
            }
            //System.out.println(Arrays.toString(vector));
        }
    }

    public void bubbleSort(int[] vector){
        for(int i = 0; i < vector.length - 1; i++){
            for(int j = 0; j < vector.length - i - 1; j++){
                if(vector[j] > vector[j+1]){
                    int aux = vector[j];
                    vector[j] = vector[j+1];
                    vector[j+1] = aux;
                }
            }
            //System.out.println(Arrays.toString(vector));
        }
    }
}
