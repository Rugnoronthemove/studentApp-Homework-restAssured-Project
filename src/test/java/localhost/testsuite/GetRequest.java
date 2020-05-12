package localhost.testsuite;

import localhost.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest extends TestBase {

    @Test
    public void getStudentList() {
        given()
                .log()
                .headers()

                .when()
                .log()
                .uri()
                .get("/list")

                .then()
                .log()
                .body()
                .body("id.size",equalTo(100))
                .statusCode(200);
    }

    @Test
    public void getStudentById(){
        given()
                .log()
                .headers()

                .when()
                .log()
                .uri()
                .get("/2")

                .then()
                .log()
                .body()
                .body("firstName",equalTo("Murphy"))
                .statusCode(200);
    }

    @Test
    public void getStudentByProgramme() {
        given()
                .log()
                .parameters()
                .param("programme","Computer Science")

                .when()
                .get("/list")

                .then()
                .log()
                .body()
                .body("programme[0]",equalTo("Computer Science"))
                .statusCode(200);
    }

    @Test
    public void getStudentByProgrammeWithLimit() {
        given()
                .log()
                .parameters()
                .param("programme","Law")
                .queryParam("limit","2")

                .when()
                .get("/list")

                .then()
                .log()
                .body()
                .body("id.size",equalTo(2))
                .statusCode(200);
    }

}
