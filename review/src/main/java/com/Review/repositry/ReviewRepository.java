package com.Review.repositry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Review.model.Review;

public interface ReviewRepository extends MongoRepository<Review, Integer> {

}
