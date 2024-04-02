public class Queue {
    int[] elements;
    int beginning;
    int end;
    int amount;
    int size;

    void createQueue(int maxSize){
        size = maxSize;
        elements = new int[maxSize];
        beginning = 0;
        end = -1;
        amount = 0;
    }

    void destroyQueue(){
        elements = null;
    }

    boolean fullQueue(){
        return amount == size;
    }

    boolean emptyQueue(){
        return elements == null;
    }

    void insertElement(int element){
        if(fullQueue()){
            System.out.println("Error, Queue is full");
        }else{
            end = (end + 1) % size;
            elements[end] = element;
            amount++;
        }
    }

    int removeElement(){
        int removedElement = -1;
        if(emptyQueue()){
            System.out.println("Error, Queue is empty");
        }else{
            removedElement = elements[beginning];
            beginning = (beginning + 1) % size;
            amount--;
        }
        return removedElement;
    }

    int locateElement(int element){
        int position = -1;
        for (int i = 0; i <= (size - 1); i++){
            if(elements[i] == element){
                position = i;
                break;
            }
        }
        return position;
    }

}
