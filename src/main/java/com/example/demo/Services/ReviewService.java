package com.example.demo.Services;

import com.example.demo.Entity.Review;
import com.example.demo.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository repository;

    public Review addReview(Review review){
        return repository.insert(review);
    }

    public Review updateReview(Review review){
        return repository.save(review);
    }


    public List<Review> getAllReviewsByUserId(String userId){
        return repository.getAllReviewsByUserId(userId);
    }

    public  List<Review> getAllReviewsByUsername(String username){
        return repository.getAllReviewsByUsername(username);
    }

    public void deleteReviewById(String id){
        repository.deleteById(id);
    }
    public Optional<Review> getReviewById(String id){
        return repository.findById(id);
    }


    public List<Review> getAllReviews(){
        return repository.findAll();
    }
}
