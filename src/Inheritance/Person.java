package Inheritance;

public class Person {
    String name;
    private int age;
    public void setAge(int age){
        this.age = age;
    }
    char gender;

    Person(){}
    Person(String name, int age, char gender){
//        System.out.println("Person class constructor called");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void print(){
        System.out.println("Name : "+this.name);
        System.out.println("Age : "+this.age);
        System.out.println("Gender : "+this.gender);
    }

}
