public class OpenHashTable {
    private Student[] table;
    private int size;
    private double loadFactor;
    private static final Student DELETED = new Student(Integer.MIN_VALUE, "DELETED");

    public OpenHashTable() {
        this.table = new Student[8];
        this.size = 0;
        this.loadFactor = 0.75;
    }

    public int hash(int key) {
        return key % this.table.length;
    }

    public Student get(int key) {
        int i = 0;
        int hash;

        while (i < this.table.length) {
            hash = (hash(key) + i) % this.table.length;
            if (this.table[hash] == null){
                return null;
            } else if(this.table[hash].getId() == key) {
                return this.table[hash];
            } else{
                i++;
            }
        }
        return null;
    }

    public void put(int key, Student student) {
        if((double) this.size / this.table.length >= this.loadFactor || this.size == this.table.length) {
            resize();
        }
        int i = 0;
        int hash;

        while (i < this.table.length) {
            hash = (hash(key) + i) % this.table.length;
            if (this.table[hash] == null || table[hash].getId() == key || table[hash].equals(DELETED)){
                table[hash] = student;
                this.size++;
                return;
            } else{
                i++;
            }
        }
    }

    public Student remove(int key) {
        int i = 0;
        int hash;

        while (i < this.table.length) {
            hash = (hash(key) + i) % this.table.length;
            if(table[hash] == null){
                return null;
            } else if(this.table[hash].getId() == key) {
                this.table[hash] = DELETED;
                this.size--;
                return this.table[hash];
            } else{
                i++;
            }
        }
        return null;
    }

    public void resize() {
        Student[] oldTable = this.table;
        this.table = new Student[oldTable.length * 2];
        this.size = 0;

        for (Student student : oldTable) {
            if (student != null) {
                this.put(student.getId(), student);
            }
        }
    }

    public void print() {
        System.out.println("------------------------------");
        for (int i = 0; i < this.table.length; i++) {
            System.out.print("Index " + i + ": ");
            if (this.table[i] != null) {
                System.out.print(this.table[i].getName());
                System.out.println();
            } else {
                System.out.println("NULL");
            }
        }
        System.out.println("------------------------------");
    }
}
