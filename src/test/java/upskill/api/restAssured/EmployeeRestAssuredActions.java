package upskill.api.restAssured;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;

public class EmployeeRestAssuredActions {

	public void createEmployeeRecord() throws Throwable {
	
		given().
			body(new File(System.getProperty("user.dir") + "/src/test/resource/ApiRequestPayloads/CreateEmployeePayload.json")).
		when().
			header("Content-Type", "application/json").					//Setting the header
			post("https://dummy.restapiexample.com/api/v1/create").		//Setting the request url
		then().
			assertThat().statusCode(200).								//Verify the status code
		and().
			body(matchesJsonSchema(new File(System.getProperty("user.dir") 
					+ "/src/test/resource/ApiResponseSchemas/CreateEmployeeSchema.json"))).	 //Verify the response body using json schema
		and().
			contentType(ContentType.JSON);								//Verify the response body is in json		
	}

	public void updateEmployeeRecord() throws Throwable {
		
		given().
			pathParam("id", "3017").											//Setting Parameter Employee id
			body(new File(System.getProperty("user.dir") + "/src/test/resource/ApiRequestPayloads/UpdateEmployeePayload.json")).
		when().
			header("Content-Type", "application/json").					//Setting the header
			put("https://dummy.restapiexample.com/api/v1/update/{id}").		//Setting the request url
		then().
			assertThat().statusCode(200).								//Verify the status code
		and().
			body(matchesJsonSchema(new File(System.getProperty("user.dir") 
					+ "/src/test/resource/ApiResponseSchemas/UpdateEmployeeSchema.json"))).	 //Verify the response body using json schema
		and().
			contentType(ContentType.JSON);								//Verify the response body is in json	
	}

	public void getAllEmployeeData() throws Throwable {

		given().
		when().
			header("Content-Type", "application/json").					//Setting the header
			get("https://dummy.restapiexample.com/api/v1/employees").	//Setting the request url
		then().
			assertThat().statusCode(200).								//Verify the status code
		and().
			body(matchesJsonSchema(new File(System.getProperty("user.dir") 
					+ "/src/test/resource/ApiResponseSchemas/GetAllEmployeeSchema.json"))).	 //Verify the response body using json schema
		and().
			contentType(ContentType.JSON);								//Verify the response body is in json	
	}

	public void getEmployeeDataById() throws Throwable {

		given().
			pathParam("id", "4").											//Setting Parameter Employee id
		when().
			header("Content-Type", "application/json").						//Setting the header
			get("https://dummy.restapiexample.com/api/v1/employee/{id}").	//Setting the request url
		then().
			assertThat().statusCode(200).									//Verify the status code
		and().
			body(matchesJsonSchema(new File(System.getProperty("user.dir") 
					+ "/src/test/resource/ApiResponseSchemas/GetEmployeeSchema.json"))).	//Verify the response body using json schema
		and().
			contentType(ContentType.JSON);									//Verify the response body is in json
	}

	public void deleteEmployeeRecord() throws Throwable {

		given().
			pathParam("id", "3017").										//Setting Parameter Employee id
		when().
			header("Content-Type", "application/json").						//Setting the header
			delete("https://dummy.restapiexample.com/api/v1/delete/{id}").	//Setting the request url
		then().
			assertThat().statusCode(200).									//Verify the status code
		and().
			body(matchesJsonSchema(new File(System.getProperty("user.dir") 
					+ "/src/test/resource/ApiResponseSchemas/DeleteEmployeeSchema.json"))).	//Verify the response body using json schema
		and().
			contentType(ContentType.JSON);									//Verify the response body is in json
	}
}
