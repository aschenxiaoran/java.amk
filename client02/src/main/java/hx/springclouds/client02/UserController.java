package hx.springclouds.client02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @GetMapping(value = "/all")
    public String getUsers(){
        return "123456";
    }
}
