package localhost.testsuite;

import localhost.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest extends TestBase {

    @Test
    public void deleteStudent() {

        given()
                .log()
                .uri()

                .when()
                .delete("/103")

                .then()
                .log()
                .status()
                .statusCode(204);

    }
}
