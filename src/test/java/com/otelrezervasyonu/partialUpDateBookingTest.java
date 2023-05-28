package com.otelrezervasyonu;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class partialUpDateBookingTest extends BaseTest {
    @Test
    public void partialUpDateBooking(){
        //Token oluşturma tek seferlik kullanıdğımız için direkt kullandığımız yerde yazabilitz

        //rezervasyon oluştur

        //çağrıyı yap
        JSONObject body=new JSONObject();
        body.put("fisrtname","SEÇİL");
        Response response=given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+createToken())
                .body(body.toString())
                .when()
                .patch("/booking/"+createBookingId());
        Assertions.assertEquals("SEÇİL",response.jsonPath().getJsonObject("firstname"));
    }
}
