import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.createQueue(10);
        queue.insertElement(10);
        queue.insertElement(20);
        queue.insertElement(30);
        System.out.println("Removed element: "+ queue.removeElement());
        queue.insertElement(40);
        queue.insertElement(50);
        queue.insertElement(60);
        queue.insertElement(70);
        queue.insertElement(80);
        queue.insertElement(90);
        queue.insertElement(100);
        queue.insertElement(110);
        System.out.println("Removed element: "+ queue.removeElement());
        queue.insertElement(120);
        queue.insertElement(130);
        int position = queue.locateElement(20);
        if(position != -1){
            System.out.println("Element 20 found on position: " + position);
        }else{
            System.out.println("Element 20 not found");
        }
        System.out.println(Arrays.toString(queue.elements));
        queue.destroyQueue();
    }
}