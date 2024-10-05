public class Main {
    public static void main(String[] args) {
        OpenHashTable table = new OpenHashTable();
        //52, 45, 64, 34, 69, 11, 10, 3, 6, 02
        Student student1 = new Student(52,"1");
        Student student2 = new Student(45,"2");
        Student student3 = new Student(64,"3");
        Student student4 = new Student(34,"4");
        Student student5 = new Student(69,"5");
        Student student6 = new Student(11,"6");
        Student student7 = new Student(10,"7");
        Student student8 = new Student(3,"8");
        Student student9 = new Student(6,"9");
        Student student10 = new Student(02,"10");
        table.put(52,student1);
        table.print();
        table.put(45,student2);
        table.print();
        table.put(64,student3);
        table.print();
        table.put(34,student4);
        table.print();
        table.put(69,student5);
        table.print();
        table.put(11,student6);
        table.print();
        table.put(02,student7);
        table.print();
        table.put(3,student8);
        table.print();
        table.put(6,student9);
        table.print();
        table.put(2,student10);
        table.print();
        System.out.println(table.get(45));
        System.out.println(table.get(75));
        table.remove(11);
        table.print();
    }
}