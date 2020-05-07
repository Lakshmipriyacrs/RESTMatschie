package api.services;

import api.model.IncidentDetails;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateIncident {

	
	 public RequestSpecification setup() {
	        return RestAssured.given()
	                .contentType(ContentType.JSON)
	                .filters(new RequestLoggingFilter(),
	                        new RequestLoggingFilter(),
	                        new AllureRestAssured());
	    }

	    @Step
	    public ValidatableResponse createNewIncident(IncidentDetails incidentInfo) {
	        		return setup()
	        		.given()
	        		.log()
	        		.all()
	                .body(incidentInfo)
	                .when()
	                .post("incident")
	                .then().log().all()
	                .assertThat()
	                .statusCode(201);
	    }
}
