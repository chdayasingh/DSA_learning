package OOPs;

public class Student {
    private String name;
    final private int rollNumber;
    double cgpa;
    private static int numStudent;
    final static double conversionFactor = 9.5;

    // Constructor (similar to function) called only when object is created
    public Student(String name, double cgpa){
        this.name = name;
        numStudent++;
        this.rollNumber = numStudent;
        this.cgpa = cgpa;
    }
    public Student(String name){
        this.name = name;
        numStudent++;
        this.rollNumber = numStudent;
    }

    public Student(){
        this.name = "Not Set";
        numStudent++;
        this.rollNumber = numStudent;
    }

    public int getRollNumber(){
//        return rollNumber; // works because there is only one rollNumber variable
        return this.rollNumber;
    }
//    public void setRollNumber(int rollNumber){
//        if(rollNumber < 1){
//            return;
//        }
//        this.rollNumber = rollNumber;
//    }

    public void setName(String str){
        if(str.length() < 3){
            System.out.println("Invalid Name");
            return;
        }
        name = str;
    }

    public String getName() {
        return name;
    }

    public void print(){
        System.out.println("Student Details");
        System.out.println("Name: " + this.name);
        System.out.println("Roll number: " + this.rollNumber);
        System.out.println("CGPA: " + this.cgpa);
        System.out.println();
    }

    public static int getNumStudent(){
//        System.out.println(rollnumber); // can't use non-static variable in static function
        return numStudent;
    }
}
