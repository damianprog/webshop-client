package com.webshop.webapp.entity;

public class ReviewAndRating {

	private int productId;

	private Review review;

	private int rating;

	public ReviewAndRating(int productId, Review review, int rating) {
		this.productId = productId;
		this.rating = rating;
		this.review = review;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

}
