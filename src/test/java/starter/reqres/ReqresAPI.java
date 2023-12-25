package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constants.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constants.BASE_URL+"/api/users";

    public static String POST_LOGIN_SUCCESFUL_USER = Constants.BASE_URL+"/api/login";
    public static String POST_LOGIN_UNSUCCESFUL_USER = Constants.BASE_URL+"/api/login";

    public static String GET_DELAYED_RESPONSE = Constants.ORIGIN_URL_REQRES+"/api/users?delay={delay}";

    public static String GET_SINGLE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";

    public static String REGISTER_USER = Constants.BASE_URL+"/api/register";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";

    // anotasi @Step adalah langkah2 skenario pengujian
    @Step("Get list users")
    public void GetListUsers(int page)
    {
        //langkah untuk mendapatkan get list users
        // Membuat permintaan HTTP GET menggunakan SerenityRest
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Post create new user")
    public void postCreateUser(File json)
    {
        //langkah untuk membuat post create new user
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update user")
    public void updateUser(int id , File json)
    {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id)
    {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete user invalid")
    public void deleteUserInvalid(String id)
    {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get delayed response")
    public void GetdelayedResponse(int delay)
    {
        SerenityRest.given()
                .pathParam("delay", delay);
    }

    @Step("Post login successful user")
    public void PostloginSuccessful(File json)
    {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login unsuccessful user")
    public void PostloginUnsuccessful(File json)
    {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register successful user")
    public void PostRegisterSuccessful(File json)
    {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register unsuccessful user")
    public void PostRegisterUnsuccessful(File json)
    {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Modify user")
    public void modifyUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get single user 2")
    public void getSingleUser2(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Modify user invalid")
    public void modifyInvalidUser(String id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}

//SerenityRest adalah bagian dari framework pengujian Serenity BDD yang menyediakan kemampuan
// untuk membuat permintaan HTTP (HTTP requests) dan mengelola respons HTTP saat menjalankan skenario
// pengujian. Dengan menggunakan SerenityRest, pengguna dapat mengintegrasikan pengujian API
// (Application Programming Interface) ke dalam skenario BDD mereka.

//given() digunakan untuk menginisialisasi permintaan HTTP
//dan mendefinisikan konfigurasi seperti base URI.

//.pathParam("userId", userId) digunakan untuk menetapkan nilai
// "123" pada path parameter dengan nama "userId".
//String userId = "123";