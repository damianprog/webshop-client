package com.webshop.webapp.factories;

import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Rating;

@Component
public class RatingFactoryImpl extends RatingFactory{

	@Override
	public Rating createInstance() {
		return new Rating();
	}

}
