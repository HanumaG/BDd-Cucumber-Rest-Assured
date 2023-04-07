package com.api.stepdefinition;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.api.test.pojo.CreateEmployee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import com.api.test.pojo.GetEmployeePOJO;
import com.api.test.pojo.CreateEmployee;

public class GetEmployeeStepDefinition {
	private static final Logger LOG = LogManager.getLogger(CreateUserStepDefinition.class);
	public RequestSpecification request;
	public Response response;
	
	
	@When ("user wants to get employee id {string} by calling endpoint {string}")
	public void user_gets_employee_details(String id, String apiMethod ) {		
		
		 request = RestAssured.given().header("Content-Type", "text/plain").queryParams("id", "358").log().all();
		
		response= request.get(apiMethod);
				
		 RestAssured.given().log().all();
		System.out.println(RestAssured.given().log().all());
		System.out.println("status code" + response.getStatusCode());

	}
	
	@When ("user wants to get all employee by calling endpoint {string}")
	public void user_gets_all_employee(String apiMethod ) {		
		
		 request = RestAssured.given().header("Content-Type", "text/plain").log().all();
		
		response= request.get(apiMethod);
				
		 RestAssured.given().log().all();
		System.out.println(RestAssured.given().log().all());
		System.out.println("status code" + response.getStatusCode());

	}
	
	
	@Then("the response should be same as schema {string}")
	public void userValidatesResponseWithJSONSchema(String schemaFileName) {
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/"+schemaFileName));
		LOG.info("Successfully Validated schema from "+schemaFileName);
	}
		
	@Then("user should get the status code as {int}")
	public void user_should_get_status_code(int statuscode) {
		Assert.assertEquals(response.getStatusCode(), statuscode);
		
		System.out.println("responsebody is " + response.body().asString());
	}
	
	
	
	
	@And("validate the JSON Response has expected data")
	public void verifyresponse(DataTable dataTable) throws JsonProcessingException
	{
		Map<String,String> getEmployeeData = dataTable.asMaps().get(0);
		ObjectMapper om = new ObjectMapper();
		
		GetEmployeePOJO[] empresponse = response.getBody().as(GetEmployeePOJO[].class);
		
	//	String resString = response.getBody().asString();
		String empData = om.writeValueAsString(empresponse[0]);
		GetEmployeePOJO emp = om.readValue(empData, GetEmployeePOJO.class);
		
	    Assert.assertEquals(emp.getCreatedAt(), getEmployeeData.get("createddate")); 
	    Assert.assertEquals(emp.getEmployee_firstname(), getEmployeeData.get("firstname"));
	    Assert.assertEquals(emp.getEmployee_lastname(), getEmployeeData.get("lastname"));
	    Assert.assertEquals(emp.getEmployee_phonenumbe(), getEmployeeData.get("phone"));
	    Assert.assertEquals(emp.getAdemployee_emaildress(), getEmployeeData.get("email"));
	    Assert.assertEquals(emp.getCitemployee_addressy(), getEmployeeData.get("city"));
	    Assert.assertEquals(emp.getStateemployee_dev_level(), getEmployeeData.get("state"));
	    Assert.assertEquals(emp.getEmployee_gender(), getEmployeeData.get("gender"));
	//    Assert.assertEquals(emp.getEmployee_hire_date(), getEmployeeData.get("hiredate"));
	   
		    

	}
	@And("validate the get JSON Response ")
	public void verify_all_employeedetails() throws JsonProcessingException
	{
		//Map<String,String> getEmployeeData = dataTable.asMaps().get(0);
		ObjectMapper om = new ObjectMapper();
		
		GetEmployeePOJO[] empresponse = response.getBody().as(GetEmployeePOJO[].class);
		
	//	String resString = response.getBody().asString();
		String empData = om.writeValueAsString(empresponse);
		GetEmployeePOJO[] emp = om.readValue(empData, GetEmployeePOJO[].class);
		
	System.out.println( "lenght is " + emp.length);
	   
		    

	}
	
	
	
}
