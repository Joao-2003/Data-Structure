import java.util.ArrayList;

public class ChainingHashTable {
    private ArrayList<Student>[] table;

    public ChainingHashTable() {
        this.table = new ArrayList[8];
    }

    public int hash(int key) {
        return key % this.table.length;
    }

    public Student get(int key) {
        int hash = this.hash(key);
        ArrayList<Student> students = this.table[hash];
        if (students == null) {
            return null;
        }
        for (Student student : students) {
            if(student.getId() == key){
                return student;
            }
        }
        return null;
    }

    public void put(int key, Student value) {
        int hash = this.hash(key);
        ArrayList<Student> students = this.table[hash];
        if (students == null) {
            students = new ArrayList<Student>();
            students.add(value);
            this.table[hash] = students;
        } else {
            for(int i = 0; i < students.size(); i++){
                if(students.get(i).getId() == key){
                    students.set(i, value);
                    return;
                }
            }
            students.add(value);
        }
    }

    public Student remove(int key) {
        int hash = this.hash(key);
        ArrayList<Student> students = this.table[hash];
        for (Student student : students) {
            if(student.getId() == key){
                students.remove(student);
                return student;
            }
        }
        return null;
    }

    public int size() {
        return this.table.length;
    }

    public void print() {
        System.out.println("------------------------------");
        for (int i = 0; i < this.table.length; i++) {
            System.out.print("Index " + i + ": ");
            ArrayList<Student> studentList = this.table[i];
            if (studentList != null && !studentList.isEmpty()) {
                for (Student student : studentList) {
                    System.out.print(student.getName() + " ");
                }
                System.out.println();
            } else {
                System.out.println("NULL");
            }
        }
        System.out.println("------------------------------");
    }

}


