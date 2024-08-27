public class Person {
    int id;
    int age;
    boolean sex;
    boolean pregnant;
    boolean lactating;
    boolean special;
    int priority;

    public Person(int id, int age, boolean sex, boolean pregnant, boolean lactating, boolean special) {
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.pregnant = pregnant;
        this.lactating = lactating;
        this.special = special;
        if (this.pregnant == true || this.lactating == true){
            this.priority = 3;
        } else if (this.special == true){
            this.priority = 2;
        } else if (this.age >= 60){
            this.priority = 1;
        } else {
            this.priority = 0;
        }
    }
}
