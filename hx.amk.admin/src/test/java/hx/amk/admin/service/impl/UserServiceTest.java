package hx.amk.admin.service.impl;

import hx.amk.admin.dto.AddUserRequest;
import hx.amk.admin.service.IUserService;
import hx.amk.infrastructure.entities.DefaultLoginUser;
import hx.amk.infrastructure.entities.ILoginUser;
import hx.amk.infrastructure.validation.JsonResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void addUser() {
        ILoginUser loginUser=new DefaultLoginUser();
        AddUserRequest request=createAddUserRequest();
        JsonResponse response=userService.addUser(request,loginUser);
        Assert.assertTrue(response.getIsValid());
    }

    private AddUserRequest createAddUserRequest() {
        AddUserRequest user=new AddUserRequest();
        user.setName("xiaoran");

        return user;
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


}