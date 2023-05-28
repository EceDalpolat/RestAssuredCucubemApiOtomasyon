package com.otelrezervasyonu;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingsTest extends BaseTest{
    //Çağrıyı oluşturmak gerekiyor
   @Test
    public void getAllBookingTest(){
       given(spec)
               .when()
               .get("/booking")
               .then()
               .statusCode(200);

    }

}
