package com.example.viikko9;

public class User {
    protected String firstName;
    protected String lastName;
    protected String email;

    protected int image;
    protected String degreeProgram;

    public User(String firstName, String lastName, String email, String degreeProgram){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;

    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getDegreeProgram() {
        return degreeProgram;
    }
}
