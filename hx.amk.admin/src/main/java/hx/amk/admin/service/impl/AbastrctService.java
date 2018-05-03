package hx.amk.admin.service.impl;

import hx.amk.admin.domain.User;
import hx.amk.infrastructure.exceptions.DomainException;
import hx.amk.infrastructure.validation.JsonResponse;

public abstract class AbastrctService{


    protected   JsonResponse tryAction(Func func){

        JsonResponse response=new JsonResponse();
        try
        {
            func.invoke();
        }
        catch (DomainException exception){
            response.getErrors().addErrors(exception.getValidationErrors().getErrorItems());
        }
        catch (Exception exception){
            response.getErrors().addSystemError("systemError",exception);
        }

        return response;
    }
}
