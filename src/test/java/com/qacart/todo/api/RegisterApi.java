package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UsersUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static com.qacart.todo.config.EndPoint.API_REGISTER_ENDPOINT;
import static io.restassured.RestAssured.given;

public class RegisterApi {
    //private elements
    private static String accessToken;
    private static String userId ;
    private static String firstName ;
    private Cookies restAssuredCookeies;
    public Cookies getRestAssuredCookeies() {
        return  this.restAssuredCookeies;
    }
    public String getAccessToken() {
        return this.accessToken;
    }
    public String getuserId() {
        return this.userId;
    }
    public String getFirstName () {
        return this.firstName;
    }
    public void register ()
    {
        //generate random data
        User user = UsersUtils.generateRandomUsers();
        /*
        User user = new User("waleeed","Gamaal","waleedgamalmahmoud12@gmail.com","123d4567");
        */
        Response response =
                given()
                        .baseUri("https://qacart-todo.herokuapp.com")
                        .header("Content-Type","application/json")
                        .body(user)
                        .log().all()   //debugging
                .when()
                        .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                        .log().all()
                        .extract().response();
        if (response.statusCode() != 201)
        {
            throw  new RuntimeException("something went wrong in the request ");
        }
        restAssuredCookeies = (Cookies) response.detailedCookies();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");

    }
}
