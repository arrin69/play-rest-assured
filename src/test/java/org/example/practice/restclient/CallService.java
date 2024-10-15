package org.example.practice.restclient;


import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import lombok.Builder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.practice.utils.Utils;

@Builder
public class CallService {

    private static final Log log = LogFactory.getLog(CallService.class);
    private RestVerb withVerb;
    private String endpoint;
    private RestAssuredConfig restAssuredConfig;
    private HeaderConfig headerConfig;

    public Response perform() {
        String baseUrl = Utils.readFromProperties("vop.base.endpoint");

        final String url = baseUrl + "/api/users";
        switch (withVerb) {
            case GET -> {
                log.info("performing get calk with " + url);
                return RestAssured.given().get(url);
            }
            case POST -> {
                return RestAssured.given().post(url);
            }
            case PUT -> {
                return RestAssured.given().put(url);
            }
            case DELETE -> {
                return RestAssured.given().delete(url);
            }
            default -> {
                log.error("Not a valid verb " + withVerb);
                throw new RuntimeException();
            }
        }
    }

}
