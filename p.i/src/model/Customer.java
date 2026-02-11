package model;

public class Customer extends User {

    public Customer () {
    }

    public Customer(int id, String name, String tellephoneNumber, String email) {
        super(id, name, tellephoneNumber, email);
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
}
