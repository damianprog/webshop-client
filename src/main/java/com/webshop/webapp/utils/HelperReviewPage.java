package com.webshop.webapp.utils;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.webshop.webapp.entity.Review;

public class HelperReviewPage extends PageImpl<Review>{

	@JsonCreator
	@JsonIgnoreProperties(ignoreUnknown = true)
	public HelperReviewPage(@JsonProperty("content") List<Review> content,
            @JsonProperty("number") int number,
            @JsonProperty("size") int size,
            @JsonProperty("totalElements") Long totalElements) {
		
		super(content,new PageRequest(number,size),totalElements);
		
	}
	
}
