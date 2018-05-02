package hx.amk.admin.controller;


import hx.amk.admin.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public UserDto listUser(@RequestParam String userName){
        UserDto user=new UserDto();
        return user;
    }
}
