package hx.amk.admin.validator;

import com.baidu.unbiz.fluentvalidator.*;
import hx.amk.admin.dao.UserDao;
import hx.amk.admin.dto.AddUserRequest;
import hx.amk.infrastructure.validation.fluentValidation.LengthValidator;
import hx.amk.infrastructure.validation.fluentValidation.NotEmptyValidator;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;

public class AddUserValidator {

    private final UserDao userDao;

    public AddUserValidator(UserDao userDao) {
        this.userDao = userDao;
    }

    public ComplexResult validate(AddUserRequest request){
        ComplexResult result=FluentValidator.checkAll()
                .on(request.getCode(),new NotEmptyValidator("code"))
                .on(request.getCode(),new LengthValidator(1,100))
                .on(request.getName(),new NotEmptyValidator("name"))
                .on(request.getName(),new LengthValidator(1,100))
                .doValidate()
                .result(toComplex());
        return  result;

    }


}
