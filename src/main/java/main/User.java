package main;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class User {

    private final String NAME = "mda";
    private final String EMAIL = "menshikoffda@yandex.ru";
    private final String PASSWORD = "1q2w3e4r5t";
    private final String URI = "https://stellarburgers.nomoreparties.site";

    public String getNAME() {
        return NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public ValidatableResponse register() {
        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(URI)
                .and()
                .body(String.format("{\"name\": \"%s\", \"email\": \"%s\", \"password\": \"%s\"}", NAME, EMAIL, PASSWORD))
                .when()
                .post("/api/auth/register")
                .then().log().all();
    }

    public ValidatableResponse login() {
        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(URI)
                .and()
                .body(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", EMAIL, PASSWORD))
                .when()
                .post("/api/auth/login")
                .then().log().all();
    }

    public String getAccessToken(ValidatableResponse valResp) {
        return valResp.extract().path("accessToken").toString();
    }

    public ValidatableResponse deleteUser(String accessToken) {
        return  given().log().all()
                .header("Authorization", accessToken)
                .baseUri(URI)
                .when()
                .delete("/api/auth/user")
                .then().log().all();
    }
}
