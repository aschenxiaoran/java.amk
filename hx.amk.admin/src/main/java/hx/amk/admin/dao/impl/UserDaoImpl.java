package hx.amk.admin.dao.impl;

import hx.amk.admin.dao.UserDao;
import hx.amk.admin.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    private final SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insert(User user) {

        int result=sqlSession.insert("insert",user);
    }
}
