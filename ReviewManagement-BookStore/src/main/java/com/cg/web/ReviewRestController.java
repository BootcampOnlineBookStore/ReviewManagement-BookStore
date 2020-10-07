package com.cg.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.cg.entity.Review;
import com.cg.service.ReviewService;



@RestController
@RequestMapping("/Review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewRestController {
	@Autowired
	ReviewService reviewService;

	@PutMapping(value = "/UpdateReview", produces = "application/json")
	public ResponseEntity<Review> updateReview(@RequestBody Review review) {
		if (review == null) {
			throw new RuntimeException("review is null");
		}
		return reviewService.updateReview(review);
	}

	

	@GetMapping(value = "/getReviewByBookId/{bookId}", produces = "application/json")
	public ResponseEntity<Optional<List<Review>>> getReviewByBookId(@PathVariable int bookId) {
		if (bookId == 0) {
			throw new RuntimeException("bookId is null");
		}
		Optional<List<Review>> review = reviewService.getReviewByBookId(bookId);
		if (review.isPresent())
			return new ResponseEntity<Optional<List<Review>>>(review, HttpStatus.OK);
		return new ResponseEntity<Optional<List<Review>>>(review, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getReviews")
	public List<Review> getReviews() {
		return reviewService.getReviews();
	}

	@DeleteMapping("/deleteReview/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable int reviewId) {
		if (reviewId == 0) {
			throw new RuntimeException("reviewId is null");
		}
		// return reviewService.deleteReview(reviewId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PostMapping(value = "/CreateReview", produces = "application/json")
	public ResponseEntity<Review> createReview(@RequestBody Review review) {

		if (review == null) {
			throw new RuntimeException("review is null");
		}

		return reviewService.createReview(review);
	}

}



