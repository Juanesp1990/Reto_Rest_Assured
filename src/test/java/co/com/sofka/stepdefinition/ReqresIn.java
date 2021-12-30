package co.com.sofka.stepdefinition;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class ReqresIn {
    private static final String BASE_URL ="https://reqres.in";
    private static final String BASE_PATH ="api/";
    protected static final String RESOURCE_CREATE ="/users";
    protected static final String RESOURCE_UPDATE ="/users/2";

    protected void generalSetup(){
        configurationForRestAssured();

    }

    private void configurationForRestAssured(){
        RestAssured.baseURI=BASE_URL;
        RestAssured.basePath=BASE_PATH;
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter(),new ErrorLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();

    }
}
