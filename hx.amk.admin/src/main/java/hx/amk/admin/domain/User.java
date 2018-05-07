package hx.amk.admin.domain;

import hx.amk.infrastructure.aggragateRoots.impl.AggragateRoot;

public class User extends AggragateRoot {

    private String code;

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code=code;
    }
}
