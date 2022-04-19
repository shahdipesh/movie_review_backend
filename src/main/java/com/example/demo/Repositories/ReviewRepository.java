package com.example.demo.Repositories;

import com.example.demo.Entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review,String> {
    @Query(value= "{ 'userId': ?0 }")
    List<Review> getAllReviewsByUserId(String id);

    @Query(value= "{ 'username': ?0 }")
    List<Review> getAllReviewsByUsername(String name);

}
