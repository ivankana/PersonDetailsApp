package ivan.persondetailsapp;

import java.io.Serializable;

/**
 * Created by Ivan on 17.02.2016.
 * This is the Person class. A Person can have a name, last name, age, address and a post number
 * Person Class is the superclass
 * Person class had to implement Serializable in order to pass the Person Object to next activity using intent, otherwise this didn't work
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name, lastName, address;
    private int age, postNo;

    public Person(String name, String lastName, int age, String address, int postNo ){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.postNo = postNo;

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int getPostNo() {
        return postNo;
    }
}
