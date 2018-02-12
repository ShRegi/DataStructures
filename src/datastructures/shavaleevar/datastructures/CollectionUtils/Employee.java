package datastructures.shavaleevar.datastructures.CollectionUtils;

public class Employee {
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";
    private String address = "";
    private int salary;

    Employee(String firstName, String lastName) {
        this(firstName, lastName, "");
    }

    Employee(String firstName, String lastName, String middleName) {
        this(firstName, lastName, middleName, "");
    }

    Employee(String firstName, String lastName, String middleName, String address) {
        this(firstName, lastName, middleName, address, 0);
    }

    Employee(String firstName, String lastName, String middleName, String address, int salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setMiddleName(middleName);
        setAddress(address);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    int getSalary() {
        return salary;
    }

    void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
