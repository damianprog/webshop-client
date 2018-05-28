package com.webshop.webapp.utils;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.webshop.webapp.entity.Product;
import com.webshop.webapp.entity.service.ProductService;
import com.webshop.webapp.utils.service.PhotoService;

@Component
public class SponsoredModelInitializer {

	@Autowired
	private AverageRatingGetter averageRatingGetter;

	@Autowired
	private ReviewsCounter reviewsCounter;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PhotoService photoService;
	
	public ModelMap getModelMap() throws IOException {
	
		ModelMap modelMap = new ModelMap();
	
		Product sponsored = productService.getProductById(3);
		
		modelMap.addAttribute("sponsored", sponsored);
		modelMap.addAttribute("sponsoredRating", averageRatingGetter.get(sponsored.getId()));
		modelMap.addAttribute("sponsoredReviewsCount",reviewsCounter.howManyReviews(sponsored.getId()));
		modelMap.addAttribute("sponsoredPhoto",
				photoService.getEncodedImage(photoService.resize(sponsored.getProductPhoto(), 150, 150)));
		
		return modelMap;
	}
}
