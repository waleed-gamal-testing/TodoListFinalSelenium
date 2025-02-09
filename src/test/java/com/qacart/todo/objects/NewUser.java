package com.qacart.todo.objects;

public class NewUser {
    public NewUser(String firstName ,String lastName , String email ,String password ,String confirmPassword)
    {
        this.firstName = firstName ;
        this.lastName = lastName;
        this.email = email;
        this.password = password ;
        this.confirmPassword = confirmPassword ;
    }
    //properties
    private String firstName ;
    private String lastName ;
    private String email ;
    private String password ;
    private String confirmPassword ;

    //setter and getter

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
