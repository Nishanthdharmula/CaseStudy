package com.Reviwe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Review.ReviewApplication;



@SpringBootTest(classes = ReviewApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class ReviewApplicationTests {
	
	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

	@Test
	void contextLoads() {
	}
	
	 @Test
	   public void testGetAllReviews() {
	   HttpHeaders headers = new HttpHeaders();
	      HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	      ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/allReviews",
	      HttpMethod.GET, entity, String.class);  
	      assertNotNull(response.getBody());
	  }

}
