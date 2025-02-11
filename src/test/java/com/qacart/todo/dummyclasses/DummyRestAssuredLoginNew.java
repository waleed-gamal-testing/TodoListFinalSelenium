package com.qacart.todo.dummyclasses;

import com.qacart.todo.api.LoginApi;

import java.io.IOException;

public class DummyRestAssuredLoginNew {
    public static void main(String[] args) throws IOException {

        LoginApi loginApi = new LoginApi();
        loginApi.loginApi();
        System.out.println( loginApi.getRestAssuredCookeies());
        System.out.println( loginApi.getFirstName());
        System.out.println(  loginApi.getAccessToken());
        System.out.println( loginApi.getUserId());
    }


}
