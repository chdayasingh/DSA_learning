package OOP;

public class StudentUse {
    public static void main(String[] args) {
        Student s1 = new Student("Daya");
//        s1.rollNumber = 1;
//        s1.setRollNumber(18);
//        s1.name = "abc";
        s1.print();
//        System.out.println(s1);
        Student s2 = new Student("Aman");
        s2.print();

        System.out.println(Student.getNumStudents());
    }
}
