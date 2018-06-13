package hx.springclouds.eurekaconsumer.controllers;

import hx.springclouds.eurekaconsumer.feignServices.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(){
        String user=userClient.getAll();
        return user;
    }
}
