package hx.amk.admin.mapper;

import hx.amk.admin.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(User user);
}
