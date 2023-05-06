package Inheritance;

public class Teacher extends Person{
    int empId;
    String specialization;
    Teacher(String name, int age, char gender, int empId, String specialization) {
        super(name, age, gender);
        this.empId = empId;
        this.specialization = specialization;
    }
    public void print(){
        super.print();
        System.out.println("Employee ID : "+ empId);
        System.out.println("Specialization : "+specialization);
    }
}
