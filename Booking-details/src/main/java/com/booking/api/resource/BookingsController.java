package com.booking.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.booking.api.exception.ResourceNotFoundException;
import com.booking.api.model.Bookings;
import com.booking.api.repository.BookingsRepository;
import com.booking.api.service.SequenceService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/booking")
public class BookingsController {
	
	@Autowired
	private BookingsRepository repository;
	
	@Autowired
	private SequenceService service;
	
	@PostMapping("/addBookings")
	public Bookings save(@RequestBody Bookings booking){
		//generate sequence
		booking.setId(service.getSequenceNumber(Bookings.SEQUENCE_NAME));
		booking.setPnr(service.getSequenceNumbers(Bookings.SEQUENCE_PNR));
		return repository.save(booking);
	}

    @GetMapping("/findAllBookings")
    public List<Bookings> getAllBookings() {
        return repository.findAll();
    }
	
	/*@PostMapping("/addBookings")
	public String saveBookings(@RequestBody Bookings bookings) {
		repository.save(bookings);
		return "Added bookings with id : " + bookings.getId() ;
		
	}
	
	@GetMapping("/findAllBookings")
	public List<Bookings> getBookings() {
		return repository.findAll();
	}*/

	/*@GetMapping("/findBookings/{id}")
	public Optional<Bookings> getBookings(@PathVariable int id) {
		return repository.findById(id);
	}*/
	
	@GetMapping("/findBookings/{id}")
	public ResponseEntity<Bookings> getBookingsById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
		Bookings booking = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking does not exist with id:" + id));
		return ResponseEntity.ok().body(booking);
			
	}
	
	@PutMapping("/bookings/{id}")
	public ResponseEntity<Bookings> updateFlight(@PathVariable int id, @RequestBody Bookings bookingDetails) {
		Bookings bookings = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bookings does not exist with id:" + id ));
				
		
		bookings.setFirstName(bookingDetails.getFirstName());
		bookings.setLastName(bookingDetails.getLastName());
		bookings.setContactNumber(bookingDetails.getContactNumber());
		bookings.setGender(bookingDetails.getGender());
		
		
		Bookings updatedBookings = repository.save(bookings);
		return ResponseEntity.ok(updatedBookings);
		
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBookings(@PathVariable int id) {
		repository.deleteById(id);
		return "Flight deleted with id : " + id;
	}
	
	/*93rd party
	public String bookingProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}*/


}
