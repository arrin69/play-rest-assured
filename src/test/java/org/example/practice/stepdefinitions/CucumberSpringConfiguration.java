package org.example.practice.stepdefinitions;

import io.cucumber.spring.CucumberContextConfiguration;
//import org.example.practice.configuration.UserConf;
import org.example.practice.configuration.UserStore;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = UserStore.class)
@CucumberContextConfiguration
public class CucumberSpringConfiguration {
}
