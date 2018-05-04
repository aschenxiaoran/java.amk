package hx.amk.admin.controller;

import hx.amk.admin.service.IUserService;
import hx.amk.infrastructure.validation.JsonResponse;
import hx.amk.admin.dto.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private  IUserService userService;

    @PostMapping(value = "add")
    public JsonResponse addUser(@RequestBody AddUserRequest request){

        JsonResponse response=userService.addUser(request);
        return response;
    }

    @GetMapping(value = "{name}")
    public AddUserRequest getUser(@PathVariable(value = "name") String name){

        AddUserRequest user = new AddUserRequest();
        user.setName("陈萧然");
        return user;
    }

    @GetMapping(value = "")
    public List<AddUserRequest> getUsers(){
        List<AddUserRequest> users=new ArrayList<>();
        AddUserRequest user = new AddUserRequest();
        user.setName("陈啸然");
        users.add(user);
        users.add(user);
        return users;
    }
}
