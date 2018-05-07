package hx.amk.admin.validator;

import com.baidu.unbiz.fluentvalidator.ResultCollector;
import com.baidu.unbiz.fluentvalidator.ValidationResult;

public class FluentValidationResult<JsonResponse> implements ResultCollector<JsonResponse> {
    @Override
    public JsonResponse toResult(ValidationResult validationResult) {
        return null;
    }
}
