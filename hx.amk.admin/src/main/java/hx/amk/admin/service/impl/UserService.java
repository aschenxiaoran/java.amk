package hx.amk.admin.service.impl;

import hx.amk.admin.domain.User;
import hx.amk.admin.dto.AddUserRequest;
import hx.amk.admin.mapper.UserMapper;
import hx.amk.admin.repository.IUserRepository;
import hx.amk.admin.service.IUserService;
import hx.amk.infrastructure.validation.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService extends AbastrctService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonResponse addUser(AddUserRequest request) {

        JsonResponse response = tryAction(()->{
            DoValidation(request);
            User user=userMapper.toUser(request);
            userRepository.AddUser(user);
        });

        /* try
        {
            DoValidation(request);
            User user=userMapper.toUser(request);
            userRepository.AddUser(user);
        }
        catch (DomainException exception){
            response.getErrors().addErrors(exception.getValidationErrors().getErrorItems());
        }
        catch (Exception exception){
            response.getErrors().addSystemError("systemError",exception);
        }*/

        return response;
    }


    private void DoValidation(AddUserRequest request) {


    }
}

