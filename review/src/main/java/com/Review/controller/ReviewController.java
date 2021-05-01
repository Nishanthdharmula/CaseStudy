package com.Review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Review.model.Review;
import com.Review.repositry.ReviewRepository;
import com.Review.service.SequenceService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReviewController {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private SequenceService service;
	
	@PostMapping("/addreview")
	public Review save(@RequestBody Review user){
		//generate sequence
		user.setId(service.getSequenceNumber(Review.SEQUENCE_NAME));
		return repository.save(user);
	}

    @GetMapping("/allReviews")
    public List<Review> getAllReviews() {
        return repository.findAll();
    }
	
	/*@PostMapping("/addReview")
	public String saveReview(@RequestBody Review review) {
		repository.save(review);
		return "Added flight with id : " + review.getId() ;
		
	}
	
	@GetMapping("/findReviews")
	public List<Review> getReviews() {
		return repository.findAll();
	}*/

}
