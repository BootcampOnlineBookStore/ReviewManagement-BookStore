package com.cg;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.cg.entity.Review;
import com.cg.exceptions.InvalidDetailsException;
import com.cg.exceptions.RecordNotFoundException;
import com.cg.service.ReviewService;

@SpringBootTest
class ReviewManagementBookStoreApplicationTests {
@Autowired
ReviewService reviewservice;

	
	@Test
	public void getAllReviews() {
		List<Review> reviews= reviewservice.getReviews();
		assertNotNull(reviews);
	}

	@Test
	public void getReviewById() throws RecordNotFoundException, InvalidDetailsException {
		Optional<List<Review>> review1=reviewservice.getReviewByBookId(2002);
		assertNotNull(review1);
	}
}
/*@Test
public void updateReview(Review review) {
ResponseEntity<Review> review1=reviewservice.updateReview(review);
assertTrue(review1.hasBody());}*/