package service;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReqresService {

    public static Response createUser(String name, String job) {
        return given()
                .when()
                .contentType("application/json")
                .body("{\"name\":\"%s\", \"job\":\"%s\"}".formatted(name, job))
                .post("https://reqres.in/api/users");
    }

    public static Response getUser(int id) {
        return given()
                .when()
                .contentType("application/json")
                .get("https://reqres.in/api/users/"+id);
    }

    public static Response updateUser(int id, String name, String job) {
        return given()
                .when()
                .contentType("application/json")
                .body("{\"name\":\"%s\", \"job\":\"%s\"}".formatted(name, job))
                .put("https://reqres.in/api/users/"+id);

    }

}
