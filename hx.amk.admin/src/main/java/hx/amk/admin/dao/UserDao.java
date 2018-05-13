package hx.amk.admin.dao;

import hx.amk.admin.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    void insert(User user);
}
