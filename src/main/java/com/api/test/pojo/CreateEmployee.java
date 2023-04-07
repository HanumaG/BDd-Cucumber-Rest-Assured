package com.api.test.pojo;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEmployee {
	// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/* ObjectMapper om = new ObjectMapper();
	Root root = om.readValue(myJsonString, Root.class); */
	
	    @JsonProperty("createdAt") 
	    public String getCreatedAt() { 
			 return this.createdAt; } 
	    public void setCreatedAt(String createdAt) { 
			 this.createdAt = createdAt; } 
	    String createdAt;
	    @JsonProperty("employee_firstname") 
	    public String getEmployee_firstname() { 
			 return this.employee_firstname; } 
	    public void setEmployee_firstname(String employee_firstname) { 
			 this.employee_firstname = employee_firstname; } 
	    String employee_firstname;
	    @JsonProperty("employee_lastname") 
	    public String getEmployee_lastname() { 
			 return this.employee_lastname; } 
	    public void setEmployee_lastname(String employee_lastname) { 
			 this.employee_lastname = employee_lastname; } 
	    String employee_lastname;
	    @JsonProperty("employee_phonenumbe") 
	    public String getEmployee_phonenumbe() { 
			 return this.employee_phonenumbe; } 
	    public void setEmployee_phonenumbe(String employee_phonenumbe) { 
			 this.employee_phonenumbe = employee_phonenumbe; } 
	    String employee_phonenumbe;
	    @JsonProperty("ademployee_emaildress") 
	    public String getAdemployee_emaildress() { 
			 return this.ademployee_emaildress; } 
	    public void setAdemployee_emaildress(String ademployee_emaildress) { 
			 this.ademployee_emaildress = ademployee_emaildress; } 
	    String ademployee_emaildress;
	    @JsonProperty("citemployee_addressy") 
	    public String getCitemployee_addressy() { 
			 return this.citemployee_addressy; } 
	    public void setCitemployee_addressy(String citemployee_addressy) { 
			 this.citemployee_addressy = citemployee_addressy; } 
	    String citemployee_addressy;
	    @JsonProperty("stateemployee_dev_level") 
	    public String getStateemployee_dev_level() { 
			 return this.stateemployee_dev_level; } 
	    public void setStateemployee_dev_level(String stateemployee_dev_level) { 
			 this.stateemployee_dev_level = stateemployee_dev_level; } 
	    String stateemployee_dev_level;
	    @JsonProperty("employee_gender") 
	    public String getEmployee_gender() { 
			 return this.employee_gender; } 
	    public void setEmployee_gender(String employee_gender) { 
			 this.employee_gender = employee_gender; } 
	    String employee_gender;
	    @JsonProperty("employee_hire_date") 
	    public String getEmployee_hire_date() { 
			 return this.employee_hire_date; } 
	    public void setEmployee_hire_date(String employee_hire_date) { 
			 this.employee_hire_date = employee_hire_date; } 
	    String employee_hire_date;
	    @JsonProperty("employee_onleave") 
	    public String getEmployee_onleave() { 
			 return this.employee_onleave; } 
	    public void setEmployee_onleave(String employee_onleave) { 
			 this.employee_onleave = employee_onleave; } 
	    String employee_onleave;
	    @JsonProperty("tech_stack") 
	    public ArrayList<Object> getTech_stack() { 
			 return this.tech_stack; } 
	    public void setTech_stack(ArrayList<Object> tech_stack) { 
			 this.tech_stack = tech_stack; } 
	    ArrayList<Object> tech_stack;
	    @JsonProperty("project") 
	    public ArrayList<Object> getProject() { 
			 return this.project; } 
	    public void setProject(ArrayList<Object> project) { 
			 this.project = project; } 
	    ArrayList<Object> project;
	    @JsonProperty("id") 
	    public String getId() { 
			 return this.id; } 
	    public void setId(String id) { 
			 this.id = id; } 
	    String id;
	}




