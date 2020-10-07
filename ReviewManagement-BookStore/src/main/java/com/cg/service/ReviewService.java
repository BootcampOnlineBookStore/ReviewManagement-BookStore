package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Review;
@Service
public interface ReviewService {

	ResponseEntity<Review> updateReview(Review review);

	Optional<List<Review>> getReviewByBookId(int bookId);

	List<Review> getReviews();

	String deleteReview(int reviewId);

	ResponseEntity<Review> createReview(Review review);
	
}
