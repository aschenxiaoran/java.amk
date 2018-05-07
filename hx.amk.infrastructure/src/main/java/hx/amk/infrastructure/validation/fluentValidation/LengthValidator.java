package hx.amk.infrastructure.validation.fluentValidation;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import hx.amk.infrastructure.extensions.StringHelper;


public class LengthValidator extends ValidatorHandler<String> implements Validator<String> {

    private Integer min=0;
    private Integer max=Integer.MAX_VALUE;

    public LengthValidator(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean validate(ValidatorContext context, String t){
        if(!StringHelper.isNullOrEmpty(t) && (t.length()<min || t.length()>max)){
            context.addErrorMsg(String.format("%s,字符串长度不正确，长度范围%s-%s",t,min,max));
            return false;
        }
        return true;
    }
}
