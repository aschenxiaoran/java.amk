package hx.amk.admin.extentions;


import hx.amk.admin.domain.User;
import hx.amk.admin.dto.AddUserRequest;
import hx.amk.infrastructure.entities.ILoginUser;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public  final class UserExtensions {

    public final User toUser(AddUserRequest request, ILoginUser loginUser){

        DozerBeanMapper mapper=new DozerBeanMapper();
        User user=mapper.map(request,User.class);
        user.init(loginUser);
        return user;
    }


}
