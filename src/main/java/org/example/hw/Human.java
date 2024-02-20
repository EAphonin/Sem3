package org.example.hw;

public class Human {
    private String lastName;
    private String firstName;
    private String secondName;

    public String getLastName() {
        return lastName;
    }

    private String birthday;
    private long phoneNumber;
    private char gender;

    public Human(String lastName, String firstName, String secondName, String birthday, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nПользователь:" + ' '
                + lastName + ' '
                + firstName + ' '
                + secondName + ' '
                + birthday + ' '
                + phoneNumber +
                ", Пол " + gender;
    }
}
