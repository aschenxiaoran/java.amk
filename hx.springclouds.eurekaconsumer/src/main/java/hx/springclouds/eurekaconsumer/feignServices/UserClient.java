package hx.springclouds.eurekaconsumer.feignServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka.client.02")
@Component
public interface UserClient {
    @GetMapping("/api/users/all")
    String getAll();
}
