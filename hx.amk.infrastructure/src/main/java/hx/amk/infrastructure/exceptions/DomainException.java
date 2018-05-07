package hx.amk.infrastructure.exceptions;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import hx.amk.infrastructure.validation.IValidationErrors;
import hx.amk.infrastructure.validation.ValidationErrorItem;
import hx.amk.infrastructure.validation.ValidationErrorType;
import hx.amk.infrastructure.validation.ValidationErrors;

import java.util.List;

public class DomainException extends RuntimeException {

    private IValidationErrors validationErrors;

    public DomainException() {
        this.validationErrors = new ValidationErrors();
    }

    public DomainException(List<ValidationError> validationErrors, ValidationErrorType errorType){
        InitValidationError(validationErrors);

        this.validationErrors.getErrorItems().forEach((item)->{
            item.setErrorType(errorType.toString());
        });
    }

    public IValidationErrors getValidationErrors() {
        return validationErrors;
    }

    private void InitValidationError(List<ValidationError> validationErrors) {
        this.validationErrors=new ValidationErrors();

        validationErrors.forEach((error)->{
            ValidationErrorItem errorItem=new ValidationErrorItem(error.getField(),error.getInvalidValue(),error.getErrorMsg());
            this.validationErrors.addErrors(errorItem);
        });
    }

}

