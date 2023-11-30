package get_requests;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
    Notlar:
    1-manuel testler için postman kullanacağız
    2-API otomasyon testleri için REST Assured kütüphanesini kullanıcağız
    3-Otomasyon kodları yazarken şu adımları takip edeeğiz
      a.gereksinimleri anlama
      b.test senaryolarını yazma
       i.test senaryolarını yazarken  Gherkın dilini kullanacağız
        -Given: ön koşullar:Endpoint, body
        -When: işlemler:Get,Post,Put,Delete...
        -Then:dönütler:Assert,on,Close...
        -And:Çoklu işlemlerin yapılacağı zaman kullanılır.
      c.Otomasyon kodlarını yazarken şu adımları takip ederiz
      i.  Set the url
      ii. Set the wxpected data
      iii.Send the request and the response
      iv. Do assertion

     */
    public static void main(String[] args) {
        String url="https://petstore.swagger.io/v2/pet/9898";
        Response response=given().when().get(url);
        response.prettyPrint();

        //Status kod nasıl yazdırılır?
        System.out.println("Status Code: " + response.statusCode());

        //Content Type nasıl yazdırılır?
        System.out.println("Content  type: "+response.contentType());

        //Status Line nasıl yazdırılır?
        System.out.println("Status Line:" +response.statusLine());

        //Header böümündeki bir veri nasıl yazdırılır?
        System.out.println("Header | Server :"+response.header("Server"));

         //Headers böümündeki bir veri nasıl yazdırılır?
        System.out.println("Headers | Server :"+response.headers());

        //Time bilgisi nasıl yazdırılır?
        System.out.println("Time: "+response.time());





    }
}
