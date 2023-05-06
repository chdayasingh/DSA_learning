package OOP;

public class Student {
    public String name;
    private int rollNumber;
    final static double CONV_FACTOR = 0.95;

    private static int numStudents;

//    Student(String givenName){
//        name = givenName;
//    }
    Student(String givenName){
        name = givenName;
        numStudents++;
        rollNumber = numStudents;
    }

    public static int getNumStudents(){
//        we can't access non static properties inside static function
//        System.out.println(this.rollNumber);
        return numStudents;
    }

    public void setRollNumber(int givenRollNumber){
        if(givenRollNumber <= 0){
            return;
        }
        this.rollNumber = givenRollNumber;
    }
    public int getRollNumber(){
        return rollNumber;
    }

    public void print(){
        System.out.println(this.name + " " + this.getRollNumber());
    }
}
