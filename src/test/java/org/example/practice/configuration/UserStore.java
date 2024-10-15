package org.example.practice.configuration;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.example.practice.model.Users;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserStore {
    private Response response;
    private Users users;
}
