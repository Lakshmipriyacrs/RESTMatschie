package api.tests;

import api.conditions.Condition;
import api.conditions.StatusCodeCondition;
import api.model.IncidentDetails;
import api.services.CreateIncident;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateIncidentTests {

	@BeforeMethod
	static void setUp() {
		RestAssured.baseURI = "https://dev74700.service-now.com/api/now/v2/table";
		RestAssured.authentication = RestAssured.basic("admin", "xonm0K7JgNBZ");
	}

	private CreateIncident incidentService = new CreateIncident();

	@Test
	public void incidentCreation() {
		IncidentDetails incident = new IncidentDetails()
				.setNumber("INC10000201")
				.setCategory("network")
				.setState("3")
				.setShort_description("Lambok Creation")
				.setDescription("Automation");

		// validate
		incidentService
			.createNewIncident(incident);
	}


}
