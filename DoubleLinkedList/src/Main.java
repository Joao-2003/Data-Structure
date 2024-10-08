public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        //1
        list.addToHead("Homer");
        list.addToTail("Marge");
        list.print();
        //2
        list.removeFromHead();
        list.removeFromHead();
        list.print();
        //3
        list.addToHead("Homer");
        list.insert(0,"Bart");
        list.insert(1,"Moll");
        list.print();
        //4
        list.removeFromTail();
        list.removeFromTail();
        list.removeFromTail();
        //5
        list.addToTail("Homer");
        list.addToTail("Bart");
        list.addToHead("Lisa");
        list.print();
        list.size();
        //6
        list.removeFromTail();
        list.removeFromTail();
        list.removeFromTail();
        list.print();
        //7
        list.addToTail("Homer");
        list.addToTail("Maggie");
        list.insert(0,"Bart");
        list.insert(1,"Marge");
        list.print();
        list.search("Lisa");
        //8
        list.removeFromTail();
        list.removeFromTail();
        list.removeFromTail();
        list.removeFromTail();
        //9
        list.addToHead("Homer");
        list.addToHead("Bart");
        list.print();
        list.size();
        //10
        list.search("Marge");
        list.search("Homer");
        list.search("Bart");
        list.search("Maggie");
        list.size();
        //11
        list.removeFromTail();
        list.removeFromTail();
        //12
        list.addToHead("Homer");
        list.addToHead("Bart");
        list.addToTail("Marge");
        list.insert(1, "Maggie");
        list.addToHead("Ned Flanders");
        list.addToTail("Sr.Burns");
        list.print();
        //13
        list.removeFromTail();
        list.print();
        //14
        list.delete(1);
        list.print();
        list.size();
        //15
        list.search("Marge");
        list.search("Homer");
        list.search("Bart");
        list.search("Maggie");
        list.size();
        //16
        list.removeFromHead();
        list.print();
        list.size();
        //17
        list.search("Marge");
        list.search("Homer");
        list.search("Bart");
        list.search("Maggie");
        list.size();
        //18
        list.removeFromTail();
        list.removeFromTail();
        list.removeFromTail();
        list.removeFromTail();
        list.print();
    }
}