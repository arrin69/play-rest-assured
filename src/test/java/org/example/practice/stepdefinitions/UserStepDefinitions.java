package org.example.practice.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.ScenarioScope;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.example.practice.configuration.UserStore;
import org.example.practice.model.Users;
import org.example.practice.restclient.CallService;
import org.example.practice.restclient.RestVerb;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@ScenarioScope
public class UserStepDefinitions {

    private final static Logger logger = LoggerFactory.getLogger(UserStepDefinitions.class);

    @Autowired
    UserStore userStore;

    @Given("I search for users")
    public void iSearchForUsers() {
        Response perform = CallService.builder().withVerb(RestVerb.GET).build().perform();
        Users users = perform.as(Users.class, ObjectMapperType.JACKSON_2);
        logger.info(users::toString);
        userStore.setResponse(perform);
        userStore.setUsers(users);
    }

    @Then("I must receive more than {int} user")
    public void iMustReceiveMoreThanUser(int expectedCount) {
        Assertions.assertEquals(200, userStore.getResponse().statusCode());
        Assertions.assertEquals(
                expectedCount, userStore.getUsers().getData().size(),
                "Number of users are not greater than " + expectedCount);
    }
}
