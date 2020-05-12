package localhost.testsuite;

import localhost.studentpojo.StudentPojo;
import localhost.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PutRequest extends TestBase {

    @Test
    public void updateStudentDetails() {

        List<String> courses = new ArrayList<>();
        courses.add("Download");
        courses.add("Unzip");
        courses.add("Copy");
        courses.add("Paste");

        StudentPojo sp = new StudentPojo();
        sp.setFirstName("Prime");
        sp.setLastName("Testing");
        sp.setEmail("postman@gmail.com");
        sp.setProgramme("Student App");
        sp.setCourses(courses);

        given()
                .header("Content-Type", "application/json")

                .when()
                .body(sp)
                .put("/101")

                .then()
                .log()
                .body()
                .body("msg", equalTo("Student Updated"))
                .statusCode(200);
    }

}
