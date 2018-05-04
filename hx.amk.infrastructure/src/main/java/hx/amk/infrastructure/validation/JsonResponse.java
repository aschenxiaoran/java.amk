package hx.amk.infrastructure.validation;

public final class JsonResponse {

    private IValidationErrors errors;
    private boolean isValid;

    public JsonResponse( ) {
        this.errors = new ValidationErrors();
    }

    public IValidationErrors getErrors(){
        return errors;
    }

    public boolean getIsValid(){
        isValid=this.errors.getErrorItems().size()==0;
        return isValid;
    }
}
