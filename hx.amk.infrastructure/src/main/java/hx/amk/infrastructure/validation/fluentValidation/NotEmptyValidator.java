package hx.amk.infrastructure.validation.fluentValidation;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import hx.amk.infrastructure.extensions.StringHelper;

public class NotEmptyValidator extends ValidatorHandler<Object> implements Validator<Object> {


    @Override
    public boolean validate(ValidatorContext context, Object t){
        if(t==null || t.toString().isEmpty()){

            String typeName=t.getClass().getTypeName();
            context.addError(ValidationError.create("不能为空").setField(typeName).setInvalidValue(t));
            return false;
        }
        return true;
    }
}
