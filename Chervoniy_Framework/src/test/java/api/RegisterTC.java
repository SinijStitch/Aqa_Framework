package api;

import org.testng.annotations.Test;
import service.ReqresService;

public class RegisterTC {

    @Test
    public void test() {
        ReqresService.register("eve.holt@reqres.in", "123123")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
