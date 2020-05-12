package localhost.testsuite;

import localhost.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class OptionsRequest extends TestBase {

    @Test
    public void checkRequestOptionsForListEndPoint() {
        given()

                .when()
                .options("/list")

                .then()
                .log()
                .headers()
                .statusCode(200);
    }

}
