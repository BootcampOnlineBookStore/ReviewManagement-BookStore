package com.cg;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.entity.Review;

public class ReviewRestControllerTest {
	private RestTemplate rt = new RestTemplate();
	
	@Test
	public void getAllReviews() {
		String url ="http://localhost:8084/bookstore/Review/getReviews";
		ResponseEntity<List<Review>> resp = rt.exchange(url,HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>(){});
		assertFalse(resp.getBody().isEmpty());
	}
	
	@Test
	public void getReviewById() {
		String url ="http://localhost:8084/bookstore/Review/getReviewByBookId/2002";
		ResponseEntity<List<Review>> resp = rt.exchange(url,HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>(){});
		assertFalse(resp.getBody().isEmpty());
	}
}
