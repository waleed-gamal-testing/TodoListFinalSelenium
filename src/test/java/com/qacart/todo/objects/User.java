package com.qacart.todo.objects;

public class User {
    //getter  >> setter
    //constructor to send values that i will use it
    public User(String firstName ,String lastName , String email ,String password)
    {
        this.firstName = firstName ;
        this.lastName = lastName;
        this.email = email;
        this.password = password ;
    }

    private String email ;
    private String firstName ;
    private String lastName ;
    private String password ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
