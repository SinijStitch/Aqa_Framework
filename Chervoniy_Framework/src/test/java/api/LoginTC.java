package api;

import org.testng.annotations.Test;
import service.ReqresService;

public class LoginTC {

    @Test
    public void test() {
        ReqresService.login("eve.holt@reqres.in", "cityslicka")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
