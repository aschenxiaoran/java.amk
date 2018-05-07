package hx.amk.infrastructure.entities;

public class DefaultLoginUser extends LoginUser {

    private final int userId=1;
    private final String userName="xiaoran";


    public DefaultLoginUser() {

        super.setUserId(this.userId);
        super.setName(this.userName);

    }
}
