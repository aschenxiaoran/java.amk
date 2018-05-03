package hx.amk.admin.service;

import hx.amk.admin.dto.AddUserRequest;
import hx.amk.infrastructure.validation.JsonResponse;

public interface IUserService {
    JsonResponse addUser(AddUserRequest request);
}
