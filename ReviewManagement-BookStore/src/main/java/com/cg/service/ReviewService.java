package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Review;
import com.cg.exceptions.InvalidDetailsException;
import com.cg.exceptions.RecordNotFoundException;



/************************************************************************************
 *          @author          Vaishnavi Voorelli
 *          Description      It is a service class that provides the services for managing reviews in the book store application      
  *         Version             1.0
  *         Created Date     05-10-2020
 ************************************************************************************/


@Service
public interface ReviewService {

/************************************************************************************
* Method: updateReview
                *Description: To edit an existing review in the book store application
* @param  review	      			- object of the Entity class 'Review' 
* @returns ReponseEntity object     - after executing the updateReview method
* 
                *Created By                              - Vaishnavi Voorelli
                *Created Date                            - 06-10-2020                           
 
************************************************************************************/
	ResponseEntity<Review> updateReview(Review review)throws RecordNotFoundException, InvalidDetailsException ;
	
	/************************************************************************************
	* Method: getReviewByBookId
	                *Description: To display the reviews posted by the users on a particular book by using it's Id
	* @param  bookId	      			- Id of the book for which, the reviews are requested to be displayed 
	 * @throws InvalidDetailsException 
	 * @throws RecordNotFoundException 
	* @returns Optional<List<Review>>   - returns the list of reviews posted on the book	* 
	                *Created By                              - Vaishnavi Voorelli
	                *Created Date                            - 06-10-2020                           
	 
	************************************************************************************/
	Optional<List<Review>> getReviewByBookId(int bookId) throws RecordNotFoundException, InvalidDetailsException;
	/************************************************************************************
	* Method: getReviews
	                *Description: To display the reviews posted by the users on all the books in store
	* @returns <List<Review>  - returns the list of reviews posted on all the books	* 
	                *Created By                              - Vaishnavi Voorelli
	                *Created Date                            - 06-10-2020                           
	 
	************************************************************************************/
	List<Review> getReviews()throws RecordNotFoundException;
	/************************************************************************************
	* Method: deleteReview
	                *Description: To delete a review from the page by using it's review Id
	* @param  reviewId	      			- Id of the review which needs to be deleted 
	* @returns String					- returns the statement showing whether the review is deleted or not	* 
	                *Created By                              - Vaishnavi Voorelli
	                *Created Date                            - 06-10-2020                           
	 
	************************************************************************************/
	String deleteReview(int reviewId) throws RecordNotFoundException, InvalidDetailsException;
	/************************************************************************************
	* Method: createReview
	                *Description: To display the reviews posted by the users on a particular book by using it's Id
	* @param  review	      			- object of the Entity class 'Review' 
    * @returns ReponseEntity object     - after executing the createReview method
	                *Created By                              - Vaishnavi Voorelli
	                *Created Date                            - 06-10-2020                           
	 
	************************************************************************************/
	ResponseEntity<Review> createReview(Review review)throws RecordNotFoundException, InvalidDetailsException;
	
}
