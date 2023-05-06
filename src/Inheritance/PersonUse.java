package Inheritance;

public class PersonUse {
    public static void main(String[] args) {
        Student s1 = new Student("Ajay", 22, 'M', 56, "CS");
        s1.print();
        System.out.println();
        Teacher t1 = new Teacher("Naveen",36, 'M',80,"java");
        t1.print();

//        Polymorphism
//        referenced variable of base class can reffered to object of child class
        Person p1 = new Student();
//        System.out.println(p1 + " " + s1);

    }
}
