package localhost.testsuite;

import localhost.studentpojo.StudentPojo;
import localhost.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchRequest extends TestBase {

    @Test
    public void updateSingleFieldEmail() {

        StudentPojo sp = new StudentPojo();
        sp.setEmail("pojo.sp@homework.com");

        given()
                .header("Content-Type","application/json")

                .when()
                .body(sp)
                .patch("/103")

                .then()
                .log()
                .body()
                .body("msg",equalTo("Updated"))
                .statusCode(200);
    }

}
