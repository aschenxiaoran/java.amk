package hx.amk.admin.validator;

import com.baidu.unbiz.fluentvalidator.*;
import hx.amk.admin.dto.AddUserRequest;
import hx.amk.admin.repository.IUserRepository;
import hx.amk.infrastructure.validation.fluentValidation.LengthValidator;
import hx.amk.infrastructure.validation.fluentValidation.NotEmptyValidator;

import java.util.List;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;

public class AddUserValidator {

    private final IUserRepository userRepository;

    public AddUserValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ComplexResult validate(AddUserRequest request){
        ComplexResult result=FluentValidator.checkAll()
                .on(request.getCode(),new NotEmptyValidator())
                .on(request.getCode(),new LengthValidator(1,100))
                .on(request.getName(),new NotEmptyValidator())
                .on(request.getName(),new LengthValidator(1,100))
                .doValidate()
                .result(toComplex());
        return  result;

    }


}
