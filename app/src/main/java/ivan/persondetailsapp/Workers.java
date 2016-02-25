package ivan.persondetailsapp;

/**
 * Created by Ivan on 17.02.2016.
 * Worker Class is a sub class of a person.
 * Worker Class has company, department and role of the worker as fields
 */
public class Workers extends Person{

    private String company, department, role;

    public Workers(String name, String lastName, int age, String address, int postNo, String company, String department, String role) {
        super(name,lastName,age,address,postNo);
        this.company = company;
        this.department = department;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getCompany() {
        return company;
    }

    public String getDepartment() {
        return department;
    }
}
