package com.booking.api;


import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import com.booking.api.model.Bookings;

@SpringBootTest(classes = BookingDetailsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class BookingDetailsApplicationTests {
	
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
   public void testUpdateBooking() {
       int id = 1;
       Bookings booking = restTemplate.getForObject(getRootUrl() + "/bookings/" + id, Bookings.class);
       booking.setId(1);
       booking.setFirstName("Indigo");
       booking.setLastName("spice");
       booking.setContactNumber("Pune");
       booking.setGender("Hydrabad");
       
       restTemplate.put(getRootUrl() + "/bookings/" + id, booking);
       Bookings updatedBookings = restTemplate.getForObject(getRootUrl() + "/bookings/" + id, Bookings.class);
       assertNotNull(updatedBookings);
   }
   
   @Test
   public void testGetAllBookings() {
   HttpHeaders headers = new HttpHeaders();
      HttpEntity<String> entity = new HttpEntity<String>(null, headers);
      ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/findAllBookings",
      HttpMethod.GET, entity, String.class);  
      assertNotNull(response.getBody());
  }

  @Test
  public void testGetBookingById() {
	  Bookings booking = restTemplate.getForObject(getRootUrl() + "/findBookings/1", Bookings.class);
      System.out.println(booking.getFirstName());
      assertNotNull(booking);
  }

   @Test
   public void testDeleteBooking() {
        int id = 2;
        Bookings flight = restTemplate.getForObject(getRootUrl() + "/delete/" + id, Bookings.class);
        assertNotNull(flight);
        restTemplate.delete(getRootUrl() + "/delete/" + id);
        try {
        	flight = restTemplate.getForObject(getRootUrl() + "/delete/" + id, Bookings.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   
}

}
