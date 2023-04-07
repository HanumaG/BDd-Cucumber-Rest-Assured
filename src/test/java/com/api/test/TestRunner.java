package com.api.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
			
		plugin = {"pretty"},
				glue = {"com.api.stepdefinition"},
        features = "src/test/resources/features/CreateUser.feature"
        //tags = "@GetAllEmployee"
        
		)
public class TestRunner {

}

