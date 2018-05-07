package hx.amk.infrastructure.aggragateRoots.impl;

import hx.amk.infrastructure.aggragateRoots.IAggragateRoot;
import hx.amk.infrastructure.entities.ILoginUser;

import java.util.Date;

public abstract   class AggragateRoot implements IAggragateRoot {

    private int id;
    private String name;
    private int createUserId;
    private String createUserName;
    private Date createTime;

    private int modifyUserId;
    private String modifyUserName;
    private Date modifyTime;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public int getCreateUserId() {
        return createUserId;
    }

    @Override
    public String getCreateUserName() {
        return createUserName;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public int getModifyUserId() {
        return modifyUserId;
    }

    @Override
    public String getModifyUserName() {
        return modifyUserName;
    }

    @Override
    public Date getModifyTime() {
        return modifyTime;
    }

    public  void init(ILoginUser loginUser){
        this.name=loginUser.getName();
        this.createUserId=loginUser.getUserId();
        this.createUserName=loginUser.getName();
        this.createTime= new Date();
        this.modifyUserId=loginUser.getUserId();
        this.modifyUserName=loginUser.getName();
        this.modifyTime= new Date();
    }

}
