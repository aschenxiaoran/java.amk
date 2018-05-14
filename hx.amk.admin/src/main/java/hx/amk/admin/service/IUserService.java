package hx.amk.admin.service;

import hx.amk.admin.dto.AddUserRequest;
import hx.amk.admin.dto.UserResponse;
import hx.amk.infrastructure.cache.redis.RedisCache;
import hx.amk.infrastructure.entities.ILoginUser;
import hx.amk.infrastructure.validation.JsonResponse;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserService {


    JsonResponse addUser(AddUserRequest request, ILoginUser loginUser);

    @Transactional(readOnly = true)
    List<UserResponse> getUsers();
}
