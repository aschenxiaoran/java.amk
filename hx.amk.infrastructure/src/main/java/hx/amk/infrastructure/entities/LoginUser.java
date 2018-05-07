package hx.amk.infrastructure.entities;

public class LoginUser implements ILoginUser {

    private int userId;
    private int memId;
    private String memCode;
    private String memName;
    private String name;
    private String code;
    private String email;
    private String token;
    private String roleIdList;

    public static LoginUser create(int userId,String name){
        LoginUser loginUser=new LoginUser();
        loginUser.setUserId(userId);
        loginUser.setName(name);
        return loginUser;
    }

    public void setUserId(int userId){
        this.userId=userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public int getMemId() {
        return memId;
    }

    @Override
    public String getMemCode() {
        return memCode;
    }

    @Override
    public String getMemName() {
        return memName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getRoleIdList() {
        return roleIdList;
    }
}
