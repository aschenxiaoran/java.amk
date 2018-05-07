package hx.amk.infrastructure.validation;

import java.util.List;

public interface IValidationErrors{
    IValidationErrors addErrors(List<ValidationErrorItem> errorItems);
    IValidationErrors addErrors(ValidationErrorItem errorItem);

    List<ValidationErrorItem> getErrorItems();

    IValidationErrors addSystemError(String systemError, Exception exception);
}

