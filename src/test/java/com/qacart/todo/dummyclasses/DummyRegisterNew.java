package com.qacart.todo.dummyclasses;

import com.qacart.todo.api.RegisterApi;

public class DummyRegisterNew {
    public static void main(String[] args) {


        RegisterApi registerApi = new RegisterApi(); // access to userID , access token , register fn , Cookies
        registerApi.register();
        System.out.println(registerApi.getRestAssuredCookeies());
        System.out.println(registerApi.getuserId());
        System.out.println(registerApi.getFirstName());
        System.out.println(registerApi.getAccessToken());
    }
}
