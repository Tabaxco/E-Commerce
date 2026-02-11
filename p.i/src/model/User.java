package model;

abstract class User {
    private int id;
    private String name;
    private String telephoneNumber;
    private String email;

    public User () {
    }

    public User (int id, String name, String telephoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
