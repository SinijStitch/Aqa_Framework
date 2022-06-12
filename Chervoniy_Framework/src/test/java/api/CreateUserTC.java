package api;

import model.CreateUserResponse;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.ReqresService;

public class CreateUserTC {


    @DataProvider
    public Object[][] createUserDP() {
        return new Object[][] {
                {"Sasha", "Mechanic"},
                {"Styopa", "Bandik"}
        };
    }

    @Test
    public void test(String name, String job) {
        CreateUserResponse actual = ReqresService.createUser(name, job)
                .getBody()
                .as(CreateUserResponse.class);
        CreateUserResponse expected = new CreateUserResponse();
        expected.setName(name);
        expected.setJob(job);
        Assert.assertEquals(actual, expected);
    }
}
