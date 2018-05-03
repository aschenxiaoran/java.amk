package hx.amk.infrastructure.validation;

public final class ValidationErrorItem {

    private final String propertyName;
    private final String errorMessage;
    private final Object attemptValue;

    public ValidationErrorItem(String propertyName, Object attemptValue, String errorMessage) {
        this.propertyName = propertyName;
        this.errorMessage = errorMessage;
        this.attemptValue = attemptValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Object getAttemptValue() {
        return attemptValue;
    }
}
