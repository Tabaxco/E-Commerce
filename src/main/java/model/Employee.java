package model;

public class Employee extends User{
    private String department;
    private String role;

    public Employee() {
    }

    public Employee(int id, String name, String telephoneNumber, String email, String department, String role) {
        super(id, name, telephoneNumber, email);
        this.department = department;
        this.role = role;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getTelephoneNumber() {
        return super.getTelephoneNumber();
    }

    @Override
    public void setTelephoneNumber(String telNumber) {
        super.setTelephoneNumber(telNumber);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
