package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.NewTask;
import com.qacart.todo.objects.Task;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.response.Response;

import java.io.IOException;
import java.rmi.RemoteException;

import static io.restassured.RestAssured.given;

public class TaskApi {
   /* public void addTask(String accessToken) throws IOException {
        Task task = new Task("learn selenium",true );
        System.out.println(task);
        Response response =
                given()
                    .baseUri(ConfigUtils.getInstance().getBaseUrl())
                    .header("Content-Type","application/json")
                    .auth().oauth2(accessToken)
                    .body(task)
                    .log().all()
                .when()
                    .post(EndPoint.API_TASK_ENDPOINT)// /api/v1/tasks
                .then()
                    .log().all()
                    .extract().response();
        if (response.statusCode() !=201)
        {
            throw new RuntimeException("something went wrong in adding a todo item");
        }

    }
*/
   public void addTask(String accessToken) throws IOException {
       NewTask task = new NewTask("learn selenium",false );
       System.out.println(task);

       Response response =
               given()
                       .baseUri(ConfigUtils.getInstance().getBaseUrl())
                       .header("Content-Type","application/json")
                       .auth().oauth2(accessToken)
                       .body(task)
                       .log().all()
               .when()
                       .post(EndPoint.API_TASK_ENDPOINT)// /api/v1/tasks
               .then()
                       .log().all()
                       .extract().response();
       if (response.statusCode() !=201)
       {
           throw new RuntimeException("Something went wrong in adding a todo item: " + response.body().asString());
       }

   }

}
