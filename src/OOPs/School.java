package OOPs;
import java.util.*;

public class School {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);

        Student s1 = new Student("Daya", 8.8);
        Student s2 = new Student("Aman");
        Student s3 = new Student();

        s1.print();
        s2.print();
        s3.print();

        System.out.println(Student.getNumStudent());

    }
}
