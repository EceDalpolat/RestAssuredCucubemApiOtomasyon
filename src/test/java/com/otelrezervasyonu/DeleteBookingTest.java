package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends BaseTest {
    @Test
    public void deleteBooking(){
        //tokene ihtiyaç var
        //rezeRVASYON OLUŞMALI
        //delete çağrısı
        Response response=given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+createToken())
                .when()
                .delete("/booking/"+createBookingId());
        //akabinde test edeceğiz
        response.then()
                .statusCode(201);
    }
}
