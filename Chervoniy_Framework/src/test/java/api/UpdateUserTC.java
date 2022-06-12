package api;

import model.UpdateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.ReqresService;

public class UpdateUserTC {

    @Test
    public void test() {
        UpdateUserResponse actual = ReqresService.updateUser(2, "Sasha", "Pilot")
                .getBody()
                .as(UpdateUserResponse.class);
        UpdateUserResponse expected = new UpdateUserResponse();
        expected.setName("Sasha");
        expected.setJob("Pilot");
        Assert.assertEquals(actual, expected);
    }
}
