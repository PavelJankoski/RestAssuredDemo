package mk.ukim.finki.skit.additionalactivity;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import mk.ukim.finki.skit.additionalactivity.model.Professor;
import mk.ukim.finki.skit.additionalactivity.model.Subject;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.*;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
import static io.restassured.RestAssured.*;

@SpringBootTest
public class SubjectTest {
    Gson gson;
    int i = 0;

    @BeforeSuite
    public void setup(){
        baseURI = "http://localhost";
        port = 8080;
        basePath = "api/subjects";
        gson = new Gson();
    }

    @AfterMethod
    void finishedTest(){
        System.out.println("Test "+i+" has finished!");
        i++;
    }

    @AfterSuite
    void completedTesting(){
        System.out.println("All tests completed!");
    }

    @DataProvider(name = "DataForPost")
    public Object[][] subjects(){
        return new Object[][]{
                {"Subject1", new HashSet<>()},
                {"Subject2", new HashSet<>()},
                {"Subject3", new HashSet<>()},
                {"Subject4", new HashSet<>()}
        };
    }

    @Test(dataProvider = "DataForPost")
    void testPOST_Parametrized(String subjectName, Set<Professor> professors){
        String json = gson.toJson(new Subject(subjectName, professors));
        given()
                .contentType(ContentType.JSON)
                .body(json).post().then()
                .statusCode(200)
                .extract()
                .response();
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
    void testGET_attributeInSetCheck(){
        given().when()
                .get()
                .then()
                .statusCode(200)
                .assertThat()
                .body("professors[0].id[0]", equalTo(53));
    }

}
