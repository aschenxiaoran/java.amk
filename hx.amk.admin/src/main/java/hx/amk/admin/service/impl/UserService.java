package hx.amk.admin.service.impl;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import hx.amk.admin.dao.UserDao;
import hx.amk.admin.domain.User;
import hx.amk.admin.dto.AddUserRequest;
import hx.amk.admin.dto.UserResponse;
import hx.amk.admin.extentions.UserExtensions;
import hx.amk.admin.intercepts.Test;
import hx.amk.admin.intercepts.cache.RedisCache;
import hx.amk.admin.service.IUserService;
import hx.amk.admin.validator.AddUserValidator;
import hx.amk.infrastructure.entities.ILoginUser;
import hx.amk.infrastructure.exceptions.DomainException;
import hx.amk.infrastructure.services.AbastrctService;
import hx.amk.infrastructure.validation.JsonResponse;
import hx.amk.infrastructure.validation.ValidationErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService extends AbastrctService implements IUserService {

    //region private variables

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserExtensions userExtensions;

    //endregion

    //region implement IUserService methods


    @RedisCache(prefix = "User_",option = RedisCache.Option.Add)
    @Override
    public JsonResponse addUser(AddUserRequest request, ILoginUser loginUser) {

        JsonResponse response = tryAction(()->{
            DoValidation(request);
            User user= userExtensions.toUser(request,loginUser);
            userDao.insert(user);
        });

        return response;
    }

    @Override
    public List<UserResponse> getUsers() {
        List<UserResponse> userList=new ArrayList<UserResponse>();
        return userList;
    }
    //endregion

    //region private methods

    private void DoValidation(AddUserRequest request) {
        AddUserValidator validator=new AddUserValidator(userDao);
        ComplexResult result= validator.validate(request);
        if(!result.isSuccess()){
            throw new DomainException(result.getErrors(),ValidationErrorType.Body);
        }

    }

    //endregion
}

