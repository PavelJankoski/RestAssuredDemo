package mk.ukim.finki.skit.additionalactivity;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mk.ukim.finki.skit.additionalactivity.model.Professor;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
import static io.restassured.RestAssured.*;

@SpringBootTest
public class ProffesorTest {
    Gson gson;

    @BeforeSuite
    public void setup(){
        baseURI = "http://localhost";
        port = 8080;
        basePath = "api/professors";
        gson = new Gson();
    }

    @Test
    void testGET_statusCode(){
        given().when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test
    void testGET_attributeCheck(){
        given().when()
                .get()
                .then()
                .assertThat()
                .body("id[0]", equalTo(35));
    }

    @Test
    void measureResponseTime(){
//        Response response = get();
//        long timeInMS = response.time();
//        long timeInS = response.timeIn(TimeUnit.SECONDS);
//        assertTrue(600 > timeInMS);
        given().when()
                .get()
                .then()
                .time(lessThan(600L));
    }

    @Test
    void testGET_logResponse(){
        given().when()
                .get()
                .then()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    void testGET_oneProfessor(){
        given().when()
                .get("/35")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("ProfessorTest1"));
    }

    @Test
    void testPOST(){
        String json = gson.toJson(new Professor("NewProfessor", 30));
        given()
                .contentType(ContentType.JSON)
                .body(json).post().then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    void testPATCH(){
        String json = gson.toJson(new Professor("EditedProfessor", 42));
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .patch("/37")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    void testDELETE(){
        given()
                .delete("/42")
                .then()
                .statusCode(200);
    }

}
