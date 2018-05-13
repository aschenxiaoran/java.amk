package hx.amk.admin.dto;

import javax.validation.constraints.NotEmpty;

public class AddUserRequest {

    @NotEmpty
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    private String code;

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code=code;
    }

}
