package steps;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.InteractionObject;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiSteps extends InteractionObject {
    public ApiSteps(UserStory userStory) throws IOException {
        super(userStory);
    }

    public static String readFileAsString(String file) throws IOException {return new String(Files.readAllBytes(Paths.get(file))); }
    String jsonBody = readFileAsString("resources/postsApis.json");

    public void postApi(){

        Response response = given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .request("POST", "https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201)
                .body("body", equalTo("este es mi post"))
                .extract()
                .response();
    }

}
