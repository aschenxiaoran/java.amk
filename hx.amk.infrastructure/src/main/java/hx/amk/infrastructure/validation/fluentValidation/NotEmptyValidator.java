package hx.amk.infrastructure.validation.fluentValidation;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import hx.amk.infrastructure.extensions.StringHelper;

import java.lang.reflect.Type;

public class NotEmptyValidator<T> extends ValidatorHandler<T> implements Validator<T> {

    private final String fieldName;

    public NotEmptyValidator(String fieldName){
        this.fieldName=fieldName;
    }

    @Override
    public boolean validate(ValidatorContext context, T t){
        if(t==null || t.toString().isEmpty()){
//            String typeName=Class.class.getTypeName(t);
            context.addError(ValidationError.create("不能为空").setField(fieldName).setInvalidValue(t));
            return false;
        }
        return true;
    }
}
