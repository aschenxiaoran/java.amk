package hx.amk.admin.mapper;


import hx.amk.admin.domain.User;
import hx.amk.admin.dto.AddUserRequest;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public  final class UserMapper {

    public  User toUser(AddUserRequest request){
        User user=new User();
        user.setCode(request.getCode());
        user.setName(request.getName());

        return user;
    }


}
