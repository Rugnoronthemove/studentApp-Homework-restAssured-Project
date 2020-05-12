package localhost.testsuite;

import localhost.studentpojo.StudentPojo;
import localhost.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest extends TestBase {

    @Test
    public void createNewStudent() {

        List<String> courses = new ArrayList<>();
        courses.add("Postman");
        courses.add("RestAssured");

        StudentPojo sP = new StudentPojo();

        sP.setFirstName("Prime");
        sP.setLastName("Testing");
        sP.setEmail("pt@api.com");
        sP.setProgramme("Automation & Manual Tester");
        sP.setCourses(courses);

        given()
                .header("Content-Type","application/json")
                .log()
                .body()

                .when()
                .body(sP)
                .post()

                .then()
                .log()
                .body()
                .body("msg",equalTo("Student added"))
                .statusCode(201);

    }

}
