package hx.amk.infrastructure.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors implements IValidationErrors{

    private final List<ValidationErrorItem> _errorItemList;

    public ValidationErrors() {
        _errorItemList=new ArrayList<ValidationErrorItem>();
    }

    public boolean isValid(){
        return _errorItemList.size()==0;
    }

    @Override
    public IValidationErrors addErrors(List<ValidationErrorItem> errorItems){
        if(errorItems==null || errorItems.size()==0){
            return this;
        }

        _errorItemList.addAll(errorItems);
        return this;
    }

    @Override
    public IValidationErrors addErrors(ValidationErrorItem errorItem) {
        _errorItemList.add(errorItem);
        return this;
    }

    @Override
    public List<ValidationErrorItem> getErrorItems() {
        return _errorItemList;
    }

    @Override
    public IValidationErrors addSystemError(String propertyName, Exception exception) {
        return addError(propertyName,null,exception.getMessage());
    }

    private IValidationErrors addError(final String propertyName,final  Object attemptedValue,final  String errorMessage) {
        ValidationErrorItem errorItem=new ValidationErrorItem(propertyName,attemptedValue,errorMessage);
        _errorItemList.add(errorItem);
        return this;
    }

}
