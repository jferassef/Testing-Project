package test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import steps.ApiSteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ApiPrueba extends TestObject  {

    protected SuiteManager suiteM = new SuiteManager("Login");



    @DataProvider(parallel = false)
    public String[][] pruebaTestAPI() {
        String testCase = "1_test";
        String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, null);

        return casesMatrix;
    }
    @Test(dataProvider = "pruebaTestAPI")
    public void testAPI(String testCase, String id) throws Exception {
        UserStory userS = suiteM.createUserStory(testCase, id);
        ApiSteps api = new ApiSteps(userS);

        userS.testActions(() -> {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        api.postApi();

            return null;

        }).onEnd(() -> {


            return null;
        }).run();
    }

    @Test
    public void testAPIGet() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        Response response = given()
                .when()
                .request("GET", "https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200)
                .body("size()", notNullValue())
                .extract()
                .response();

        // Verifica que la respuesta de la API no está vacía
         System.out.println("Number of posts: " + response.jsonPath().getList("$").size());

    }

    @Test
    public void testAPIDelete() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        Response response = given()
                .when()
                .request("DELETE", "https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .body("size()", notNullValue())
                .extract()
                .response();

    }
}

