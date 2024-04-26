package com.nsbm.ebookstore.user.review_service.controller;

import com.nsbm.ebookstore.user.review_service.model.ReviewModel;
import com.nsbm.ebookstore.user.review_service.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/review")

public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Retrieve all comments
    @GetMapping("/comments")
    public List<ReviewModel> getAllComments() {
        return reviewService.getAllComments();
    }

    @GetMapping("/comments/{book_id}")
    public List<ReviewModel> getCommentsByBookID(@PathVariable int book_id) {
        return reviewService.GetReviewsByBookId(book_id);
    }

    @GetMapping("/comments/user/{userid}")
    public List<ReviewModel> GetUsersByBookId(@PathVariable int userid){
        return reviewService.GetUsersByBookId(userid);
    }

    @GetMapping("/comments/user/{userid}/{book_id}")
    public List<ReviewModel>GetUserBookById(@PathVariable int userid,@PathVariable int book_id){
        return reviewService.GetUserBookById(userid,book_id);
    }


    //add comment
    @PostMapping("/addComment")
    public ResponseEntity<ReviewModel> addComment(@RequestBody ReviewModel reviewModel){
        ReviewModel addedReview = reviewService.addComment(reviewModel);
        return ResponseEntity.ok(addedReview);
    }

    //delete comment
    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id){
        reviewService.deleteComment(id);
        return ResponseEntity.ok("comment deleted successfully");
    }

    //update comment
    @PutMapping("/updateComment/{id}")
    public  ResponseEntity<ReviewModel> updateComment(@PathVariable("id") Long id, @RequestBody ReviewModel comment){
        ReviewModel updatedReview = reviewService.updateComment(id, comment);
        return ResponseEntity.ok(updatedReview);
    }

}
