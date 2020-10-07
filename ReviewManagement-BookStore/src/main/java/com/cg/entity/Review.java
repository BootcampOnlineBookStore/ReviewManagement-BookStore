package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@Column(length = 200)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "mailId")
	private Customer customer;
	@Column(length = 5, name = "rating")
	private int rating;
	@Column(length = 128, name = "headline")
	private String headline;
	@Column(length = 300, name = "comments")
	private String comments;

	public Review() {
	}

	public Review(int reviewId, Book book, Customer customer, int rating, String headline, String comments) {
		this.reviewId = reviewId;
		this.book = book;
		this.customer = customer;
		this.rating = rating;
		this.headline = headline;
		this.comments = comments;
	}

	public Review(int reviewId, int rating, String headline, String comments) {
		super();
		this.reviewId = reviewId;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		return "Review [reviewId=" + reviewId + ", book=" + book + ", customer=" + customer + ", rating=" + rating
				+ ", headline=" + headline + ", comments=" + comments + "]";
	}
}
