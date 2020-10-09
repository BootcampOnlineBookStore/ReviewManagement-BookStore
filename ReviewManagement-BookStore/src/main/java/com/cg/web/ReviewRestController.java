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
import com.cg.exceptions.InvalidDetailsException;
import com.cg.service.ReviewService;


/************************************************************************************
 *          @author          Vaishnavi Voorelli
 *          Description      It is the REST Controller class where all the RESTful web services for the application to run, are implemented
  *         Version             1.0
  *         Created Date     05-10-2020
 ************************************************************************************/
@RestController
@RequestMapping("/Review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewRestController{
	@Autowired
	ReviewService reviewService;

/************************************************************************************
* Method: updateReview
                *Description: To edit an existing review in the book store application
* @param  review	      							- object of the Entity class 'Review' 
* @returns updateReview method in service layer     - after executing the updateReview method
* 
                *Created By                              - Vaishnavi Voorelli
                *Created Date                            - 06-10-2020                           
 
************************************************************************************/
	@PutMapping(value = "/UpdateReview", produces = "application/json")
	public ResponseEntity<Review> updateReview(@RequestBody Review review) throws InvalidDetailsException{
		if (review == null) {
			throw new RuntimeException("review is null");
		}
		return reviewService.updateReview(review);
	}

	

	/************************************************************************************
	* Method: getReviewByBookId
	                *Description: To display the reviews posted by the users on a particular book by using it's Id
	* @param  bookId	      								- Id of the book for which, the reviews are requested to be displayed 
	* @returns getReviewByBookId method in service layer	- after executing the getReviewByBookId method* 
	                *Created By                              - Vaishnavi Voorelli
	                *Created Date                            - 06-10-2020                           
	 
	************************************************************************************/

	@GetMapping(value = "/getReviewByBookId/{bookId}", produces = "application/json")
	public ResponseEntity<Optional<List<Review>>> getReviewByBookId(@PathVariable int bookId) throws InvalidDetailsException{
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
	public String deleteReview(@PathVariable int reviewId) throws InvalidDetailsException{
		if (reviewId == 0) {
			throw new RuntimeException("reviewId is null");
		}
		return reviewService.deleteReview(reviewId);
		//return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/CreateReview", produces = "application/json")
	public ResponseEntity<Review> createReview(@RequestBody Review review) throws InvalidDetailsException {

		if (review == null) {
			throw new RuntimeException("review is null");
		}

		return reviewService.createReview(review);
	}

}



