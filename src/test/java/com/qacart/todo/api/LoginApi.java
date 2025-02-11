package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User2;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UsersUtils;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class LoginApi {
    private Cookies restAssuredCookeies ;
    private String accessToken;
    private String userId ;
    private String firstName ;

    public Cookies getRestAssuredCookeies() {
        return this.restAssuredCookeies;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void loginApi() throws IOException {
        User2 user2 = UsersUtils.generateRandomUsersLogin();
        Response response =
                given()
                        .baseUri(ConfigUtils.getInstance().getBaseUrl())
                        .header("Content-Type","application/json")
                        .body(user2)
                        .log().all()
                .when()
                        .post(EndPoint.API_LOGIN_ENDPOINT)
                .then()
                        .log().all()  // print all response data
                        .extract().response();
        if (response.statusCode() != 200)
        {
            throw  new RuntimeException("something went wrong in the request ");
        }
        restAssuredCookeies = response.detailedCookies();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }
}
