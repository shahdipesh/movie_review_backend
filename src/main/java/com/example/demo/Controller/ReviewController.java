package com.example.demo.Controller;

import com.example.demo.Entity.Review;
import com.example.demo.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ReviewController {

    @Autowired
    ReviewService reviewService;


    @GetMapping("/reviews")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/review/{id}")
    public Optional<Review> getReviewById(@PathVariable String id){
        return reviewService.getReviewById(id);
    }

    @GetMapping("/findReviewsByUserId/{id}")
    public List<Review> getAllReviewsByUserId(@PathVariable String id){
        return reviewService.getAllReviewsByUserId(id);
    }

    @GetMapping("/findReviewsByUsername/{username}")
    public  List<Review> getAllReviewsByUsername(@PathVariable String username){
        return reviewService.getAllReviewsByUsername(username);
    }

    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }
    @PutMapping("/updateReview")
    public Review updateReview(@RequestBody Review review){
        return reviewService.updateReview(review);
    }

    @DeleteMapping("/deleteReview/{id}")
    public void deleteReviewById(@PathVariable String id){
        reviewService.deleteReviewById(id);
    }


}
