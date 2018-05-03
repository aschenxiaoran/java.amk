package hx.amk.infrastructure.exceptions;

import hx.amk.infrastructure.validation.IValidationErrors;
import hx.amk.infrastructure.validation.ValidationErrors;

public class DomainException extends RuntimeException {

    private IValidationErrors validationErrors;

    public DomainException() {
        this.validationErrors = new ValidationErrors();
    }

    public IValidationErrors getValidationErrors() {
        return validationErrors;
    }
}

