package com.otelrezervasyonu;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingByIdTets extends BaseTest {
    @Test
    public void getBookingById(){

       Response response= given(spec)
                .when()
                .get("/booking/"+createBookingId());

       response.then()
               .statusCode(200);
        String FirstName=response.jsonPath().getJsonObject("firstname");
        String lastName=response.jsonPath().getJsonObject("lastname");
        int totalPrice=response.jsonPath().getJsonObject("totalprice");
         Assertions.assertEquals("DALPOLAT",lastName);
         Assertions.assertEquals("ECE",FirstName);
         Assertions.assertEquals(1230,totalPrice);


    }
}
