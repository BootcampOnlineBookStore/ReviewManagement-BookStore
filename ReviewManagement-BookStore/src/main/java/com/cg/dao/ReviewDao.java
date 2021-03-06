package com.cg.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Review;

@Repository

/************************************************************************************
 * 			@author Vaishnavi Voorelli 
 * 		   Description : It is the DAO class where the data
 *         is retrieved from or inserted into the database 
 *         Version : 1.0 
 *         Created Date : 05-10-2020
 ************************************************************************************/
public interface ReviewDao extends JpaRepository<Review, Integer> {

	@Query("select r from Review r where r.user.email=:email_id")
	public Optional<List<Review>> getUserId(@Param("email_id") String email_id);

	@Query("select r from Review r where r.book.bookId=:bookId")
	public Optional<List<Review>> getReviewByBookId(@Param("bookId") int bookId);
}
