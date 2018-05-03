package hx.amk.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/org")
public class OrganizationController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getOrganization(){
        return new String("组织机构");
    }
}
