package com.cg.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/************************************************************************************
 *          @author          Vaishnavi Voorelli
 *          Description      It is an Entity class for Reviews 
  *         Version             1.0
  *         Created Date     05-10-2020
 ************************************************************************************/


@Entity
@Table(name = "review_tb")
public class Review {
	@Id
	@GeneratedValue(generator = "review_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "review_seq",sequenceName = "review_seq")
	private int reviewId;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "email_id")
	private User user;
	@Column(length = 5, name = "rating")
	private int rating;
	@Column(length = 128, name = "headline")
	private String headline;
	@Column(length = 300, name = "comments")
	private String comments;

	public Review() {
	}


	public Review(int reviewId, int rating, String headline, String comments) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.headline = headline;
		this.comments = comments;
	}


	public Review(int reviewId, Book book, User user, int rating, String headline, String comments) {
		super();
		this.reviewId = reviewId;
		this.book = book;
		this.user = user;
		this.rating = rating;
		this.headline = headline;
		this.comments = comments;
	}


	public int getReviewId() {
		return reviewId;
	}


	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getHeadline() {
		return headline;
	}


	public void setHeadline(String headline) {
		this.headline = headline;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", book=" + book + ", user=" + user + ", rating=" + rating
				+ ", headline=" + headline + ", comments=" + comments + "]";
	}


	
}
