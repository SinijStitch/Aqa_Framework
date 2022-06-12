package api;

import model.GetUserResponse;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.ReqresService;

public class GetUserTC {
    @Test
    public void test() {
        GetUserResponse actual = ReqresService.getUser(2)
                .getBody()
                .as(GetUserResponse.class);
        GetUserResponse expected = new GetUserResponse();
        User user = new User();
        user.setId(2);
        user.setEmail("janet.weaver@reqres.in");
        user.setFirst_name("Janet");
        user.setLast_name("Weaver");
        user.setAvatar("https://reqres.in/img/faces/2-image.jpg");
        expected.setData(user);
        Assert.assertEquals(actual, expected);
    }
}
