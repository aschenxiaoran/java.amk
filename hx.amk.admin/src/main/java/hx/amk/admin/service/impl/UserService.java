package hx.amk.admin.service.impl;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import hx.amk.admin.domain.User;
import hx.amk.admin.dto.AddUserRequest;
import hx.amk.admin.mapper.UserMapper;
import hx.amk.admin.repository.IUserRepository;
import hx.amk.admin.service.IUserService;
import hx.amk.admin.validator.AddUserValidator;
import hx.amk.infrastructure.entities.ILoginUser;
import hx.amk.infrastructure.exceptions.DomainException;
import hx.amk.infrastructure.validation.JsonResponse;
import hx.amk.infrastructure.validation.ValidationErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService extends AbastrctService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonResponse addUser(AddUserRequest request, ILoginUser loginUser) {

        JsonResponse response = tryAction(()->{
            DoValidation(request);
            User user=userMapper.toUser(request,loginUser);
            userRepository.AddUser(user);
        });

        return response;
    }


    private void DoValidation(AddUserRequest request) {
        AddUserValidator validator=new AddUserValidator(userRepository);
        ComplexResult result= validator.validate(request);
        if(!result.isSuccess()){
            throw new DomainException(result.getErrors(),ValidationErrorType.Body);
        }

    }
}

