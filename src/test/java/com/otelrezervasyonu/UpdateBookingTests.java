package com.otelrezervasyonu;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTests extends  BaseTest {
@Test
    public void updateBooking(){
    //token oluşturma

  //rezervasyon oluşturma

    //Request yap
    Response response=given(spec)
            .contentType(ContentType.JSON)
            .header("Cookie","token="+createToken())
            .body(bookingObject("YASİN","DALPOLAT",1520,false))
            .put("/booking/"+createBookingId());
    //Assertion/Test yaz
    String fisrtname=response.jsonPath().getJsonObject("firstname");
    String lastname=response.jsonPath().getJsonObject("lastname");
    int totalPrice=response.jsonPath().getJsonObject("totalprice");
    boolean depositpaid=response.jsonPath().getJsonObject("depositpaid");
    Assertions.assertEquals(false,depositpaid);
    Assertions.assertEquals(1520,totalPrice);
    Assertions.assertEquals("DALPOLAT",lastname);
    Assertions.assertEquals("YASİN",fisrtname);

}

}
