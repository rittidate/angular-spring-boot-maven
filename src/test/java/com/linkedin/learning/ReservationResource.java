package com.linkedin.learning;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.linkedin.learning.rest.ResourceConstants;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LinkedInLearningFullStackAppAngularSpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationResource {
	
	@LocalServerPort
	private int port;
	
	@Before
	public void setUp() throws Exception{
		RestAssured.port = Integer.valueOf(port);
		RestAssured.basePath = ResourceConstants.ROOM_RESERVATION_V1;
		RestAssured.baseURI = "http://localhost";
	}
	
	@Test
	public void test() {
		given().when().get("/" + 1).then()
		.statusCode(200);
	}

}
