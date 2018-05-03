package hx.amk.infrastructure.validation;

public final class JsonResponse {

    private IValidationErrors errors;

    public JsonResponse( ) {
        this.errors = new ValidationErrors();
    }

    public IValidationErrors getErrors(){
        return errors;
    }
}
