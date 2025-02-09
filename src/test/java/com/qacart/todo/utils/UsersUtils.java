package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.NewUser;
import com.qacart.todo.objects.User;
import com.qacart.todo.objects.User2;

public class UsersUtils {
    public static User generateRandomUsers()
    {
        String firstName = new Faker().name().firstName().concat("test");
        String lastName = new Faker().name().lastName().concat("test");
        String email = new Faker().name().firstName().concat("@gmail.com"); //to delete all test data from database
        String password = "WaleedGamal123";

        User user = new User(firstName,lastName,email,password);
        User2 user2 = new User2(email ,password);
        return user ;
    }
    public static User2 generateRandomUsersLogin()
    {
        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password();
        User2 user2 = new User2(email ,password);
        return user2 ;
    }
    public static NewUser generateRandomNewUserForRegister()
    {
        String firstName = new Faker().name().firstName().concat("test");
        String lastName = new Faker().name().lastName().concat("test");
        String email = new Faker().name().firstName().concat("@gmail.com"); //to delete all test data from database
        String password = "WaleedGamal1234";
        String confirmPassword ="WaleedGamal1234";

        NewUser newUser = new NewUser(firstName,lastName,email,password,confirmPassword);
        return newUser ;
    }
}
