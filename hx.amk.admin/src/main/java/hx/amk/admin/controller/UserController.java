package hx.amk.admin.controller;

import hx.amk.admin.service.IUserService;
import hx.amk.infrastructure.validation.JsonResponse;
import hx.amk.admin.dto.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    private  IUserService userService;

    @PostMapping(value = "add")
    public JsonResponse addUser(@RequestBody AddUserRequest request){

        JsonResponse response=userService.addUser(request);
        return response;
    }

    @GetMapping(value = "get")
    public AddUserRequest getUser(){
        return new AddUserRequest();
    }
}
