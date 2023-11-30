package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

public class Get06 extends HerokuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/22
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type is “application/json”
    And
        Response body should be like;
      {
        "firstname": "John",
        "lastname": "Smith",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
     */

    @Test
    public void Get() {
        //1.Set the url
        spec.pathParams("first","booking"
        ,"second",22);
        //2.Set expected
        //3.Send req get resp
        Response response=given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //4.Do assertion
        //1. yol
        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Josh"),
                        "lastname", equalTo("Allen"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds", equalTo("super bowls"));
        //2.yol
        JsonPath json= response.jsonPath();//response yi jssonpath () methodu kullanarak
        // jsonpath data çesidine dönüştürdük.Json path den response dakı datalara kolayca
        // ulaşabilirim

        //System.out.println(json.getString("firstname"));

        assertEquals("Josh",json.getString("firstname"));
        assertEquals("Allen",json.getString("lastname"));
        assertTrue(json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("super bowls",json.getString("additionalneeds"));

        //3.yol---Soft Assertion
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(json.getString("firstname"),"Josh");
        softAssert.assertEquals(json.getString("lastname"),"Allen");
        softAssert.assertEquals(json.getInt("totalprice"),111);
        softAssert.assertTrue(json.getBoolean("desppositpaid"));
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01");
        softAssert.assertEquals(json.getString("additionalneeds"),"super bowls");
        softAssert.assertAll();






    }
}
