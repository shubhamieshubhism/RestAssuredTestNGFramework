package com.spotify.oauth2.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.spotify.oauth2.api.Route.BASE_PATH;


public class SpecBuilder {
    //static String access_token ="BQCq1uTLlAWeyCMGQFxAuDE5IR2TEJUvotBxVOknsnwRuKpV79yBHKQXwoyweQmBKkGJZXS4lS5lU1aRYzqI1bGozYIcImgeZ_soER-tdbkWQfbzWEtz2Z5Y27dGpfZxVKzGZi6aJpFiZvXdP_LdDC1BkpRzgPSGZF1P3VZBec3jwzjblrDJcOTT-IFslsUiynwvfncCCaFPlfzI5QsBEPgsa1bpW_A2J8TV9z5Bujro1TwRhjwPGS0MNqlfybz5enw517FguyFnggex";

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
               // setBaseUri(System.getProperty("BASE_URI")).
               setBaseUri("https://api.spotify.com").
                setBasePath(BASE_PATH).
                //addHeader("Authorization","Bearer "+getToken()).
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).build();
    }

    public static RequestSpecification getAccountRequestSpec(){
        return new RequestSpecBuilder().
               // setBaseUri(System.getProperty("ACCOUNT_BASE_URI")).
                setBaseUri("https://accounts.spotify.com").
               // addHeader("Authorization","Bearer "+getToken()).
                setContentType(ContentType.URLENC).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                        log(LogDetail.ALL).build();

    }
}
