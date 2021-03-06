package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.dao.ReviewDao;
import com.cg.entity.Review;
import com.cg.exceptions.InvalidDetailsException;
import com.cg.exceptions.RecordNotFoundException;
@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	ReviewDao reviewDao;

	@Override
	public ResponseEntity<Review> updateReview(Review review)throws RecordNotFoundException, InvalidDetailsException{
		Optional<Review> reviews = reviewDao.findById(review.getReviewId());
		if (!reviews.isPresent())
			return new ResponseEntity<Review>(review, HttpStatus.NOT_FOUND);
		else {
			review.setBook(reviews.get().getBook());
			review.setUser(reviews.get().getUser());
			review.setRating(reviews.get().getRating());
			return new ResponseEntity<Review>(reviewDao.save(review), HttpStatus.OK);
		}
	}

	
	@Override
	public Optional<List<Review>> getReviewByBookId(int bookId)throws RecordNotFoundException,InvalidDetailsException{
		return reviewDao.getReviewByBookId(bookId);

	}

	@Override
	public List<Review> getReviews()throws RecordNotFoundException {
		return reviewDao.findAll();
	}

	@Override
	public String deleteReview(int reviewId)throws RecordNotFoundException, InvalidDetailsException {
		reviewDao.deleteById(reviewId);
		return "review Deleted";
	}

	@Override
	public ResponseEntity<Review> createReview(Review review) throws RecordNotFoundException, InvalidDetailsException{
		Optional<Review> reviews = reviewDao.findById(review.getReviewId());
		if (reviews.isPresent()) {
			review.setRating(reviews.get().getRating());
			review.setComments(reviews.get().getComments());
			review.setHeadline(reviews.get().getHeadline());
			return new ResponseEntity<Review>(review, HttpStatus.FOUND);
			}
		else 
			return new ResponseEntity<Review>(reviewDao.save(review), HttpStatus.OK);
	
			
		}
	}

          