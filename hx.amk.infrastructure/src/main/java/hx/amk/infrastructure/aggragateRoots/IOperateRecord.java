package hx.amk.infrastructure.aggragateRoots;

import java.util.Date;
import java.util.Optional;

public interface IOperateRecord {

    public int getCreateUserId();
    public String getCreateUserName();
    public Date getCreateTime();
    public int getModifyUserId();
    public String getModifyUserName();
    public Date getModifyTime();

}
