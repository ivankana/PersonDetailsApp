package ivan.persondetailsapp;

/**
 * Created by Ivan on 17.02.2016.
 * Student class is a sub class which extends person meaning it also includes everything a person has, and has school and class of the student
 */
public class Student extends Person{

    private String classOfStudent, school;

    public Student(String name, String lastName, int age, String address, int postNo, String school, String classOfStudent) {
        super(name,lastName,age,address,postNo);
        this.school = school;
        this.classOfStudent = classOfStudent;
    }

    public String getClassOfStudent() {
        return classOfStudent;
    }

    public String getSchool() {
        return school;
    }
}
