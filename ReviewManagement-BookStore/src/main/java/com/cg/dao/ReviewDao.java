package com.cg.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Review;
@Repository
public interface ReviewDao extends JpaRepository<Review, Integer> {
	
	@Query("select r from Review r where r.customer.emailAddress=:mailId")
	public Optional<List<Review>> getCustId(@Param("mailId") String mailId);

	@Query("select r from Review r where r.book.bookId=:bookId")
	public Optional<List<Review>> getReviewByBookId(@Param("bookId") int bookId);
}
