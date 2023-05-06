package Inheritance;

public class Student extends Person{
    public int rollNo;
    String course;

    public Student(){}
    public Student(String name, int age, char gender, int rollNo, String course) {
        super(name, age, gender);
//        System.out.println("Student class constructor called");
        this.rollNo = rollNo;
        this.course = course;
    }

    public void print(){
        super.print();
        System.out.println("Roll No : " + this.rollNo);
        System.out.println("Course : "+ this.course);
    }

}
