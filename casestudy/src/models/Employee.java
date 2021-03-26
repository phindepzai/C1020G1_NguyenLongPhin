package models;

public class Employee {
    private String name;
    private String birthDay;
    private String identityNumber;
    private String phoneNumber;
    private String email;
    private String level;
    private String position;
    private int salary;

    public Employee(String name, String birthDay, String identityNumber, String phoneNumber, String email, String level,
                    String position, int salary) {
        this.name = name;
        this.birthDay = birthDay;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "\nName = " + name +
                "\nBirthDay = " + birthDay +
                "\nIdentityNumber = " + identityNumber +
                "\nPhoneNumber = " + phoneNumber +
                "\nEmail = " + email +
                "\nLevel = " + level +
                "\nPosition = " + position +
                "\nSalary = " + salary ;
    }
}
