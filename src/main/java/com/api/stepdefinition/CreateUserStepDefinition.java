package com.api.stepdefinition;


//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.api.test.pojo.CreateEmployee;

public class CreateUserStepDefinition {
	private static final Logger LOG = LogManager.getLogger(CreateUserStepDefinition.class);
	public RequestSpecification request;
	public Response response;
	Map<String,String> createEmployeeData = new HashMap<String,String>();
	
	@Given("user is valid user and has access to endpoint")
	public void user_is_valid() {
		 RestAssured.baseURI ="https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1/";
		
	}
	
	@When ("user creates a employee by calling endpoint {string}")
	public void user_creates_employee(String apiMethod, DataTable dataTable ) {
		createEmployeeData = dataTable.asMaps().get(0);
		JSONObject createEmployeeBody = new JSONObject();
		
		createEmployeeBody.put("createdAt", createEmployeeData.get("createddate"));
		createEmployeeBody.put("employee_firstname", createEmployeeData.get("firstname"));
		createEmployeeBody.put("employee_lastname", createEmployeeData.get("lastname"));
		createEmployeeBody.put("employee_phonenumbe", createEmployeeData.get("phone"));
		createEmployeeBody.put("ademployee_emaildress", createEmployeeData.get("email"));
		createEmployeeBody.put("citemployee_addressy", createEmployeeData.get("city"));
		createEmployeeBody.put("stateemployee_dev_level", createEmployeeData.get("state"));
		createEmployeeBody.put("employee_gender", createEmployeeData.get("gender"));
		createEmployeeBody.put("employee_hire_date", createEmployeeData.get("hiredate"));
		createEmployeeBody.put("employee_onleave", createEmployeeData.get("Onleave"));
		
		 request = RestAssured.given().header("Content-Type", "application/json").body(createEmployeeBody.toString()).log().all();
		response= request.post(apiMethod);
				
		 RestAssured.given().log().all();
		System.out.println(RestAssured.given().log().all());

	}
	
	
	@Then("user should get the status code {int}")
	public void user_should_get_status_code(int statuscode) {
		Assert.assertEquals(response.getStatusCode(), statuscode);
		
		System.out.println("responsebody is " + response.body().asString());
	}
	
	
	@Then("the response should be as per schema {string}")
	public void userValidatesResponseWithJSONSchema(String schemaFileName) {
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/"+schemaFileName));
		LOG.info("Successfully Validated schema from "+schemaFileName);
	}

	@And("validate the JSON Response")
	public void verifyresponse() throws JsonProcessingException
	{
		ObjectMapper om = new ObjectMapper();
		
		CreateEmployee empresponse = response.getBody().as(CreateEmployee.class);
		//String resString = response.getBody().asString();
		String empData = om.writeValueAsString(empresponse);
		CreateEmployee emp = om.readValue(empData, CreateEmployee.class);
	    Assert.assertEquals(emp.getCreatedAt(), createEmployeeData.get("createddate")); 
	    Assert.assertEquals(emp.getEmployee_firstname(), createEmployeeData.get("firstname"));
	    Assert.assertEquals(emp.getEmployee_lastname(), createEmployeeData.get("lastname"));
	    Assert.assertEquals(emp.getEmployee_phonenumbe(), createEmployeeData.get("phone"));
	    Assert.assertEquals(emp.getAdemployee_emaildress(), createEmployeeData.get("email"));
	    Assert.assertEquals(emp.getCitemployee_addressy(), createEmployeeData.get("city"));
	    Assert.assertEquals(emp.getStateemployee_dev_level(), createEmployeeData.get("state"));
	System.out.println(emp.getId());	    

	}
	
}
