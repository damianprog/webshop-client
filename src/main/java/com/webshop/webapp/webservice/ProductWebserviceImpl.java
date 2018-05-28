package com.webshop.webapp.webservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webshop.webapp.entity.Product;
import com.webshop.webapp.utils.HelperProductPage;

@Service
public class ProductWebserviceImpl implements ProductWebservice {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://localhost:9000";

	@Override
	public void saveProduct(Product product) {

		restTemplate.postForObject(url + "/products", product, Product.class);

	}

	@Override
	public Product getProduct(int productId) {

		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);

		return restTemplate.getForObject(url + "/products/{productId}", Product.class, params);

	}

	@Override
	public Product getProductByName(String productName) {
		Map<String, String> params = new HashMap<>();
		params.put("productName", productName);

		return restTemplate.getForObject(url + "/products/name/{productName}", Product.class, params);
	}

	@Override
	public Page<Product> getProductsByCategory(String category, int page) {

		Map<String, String> params = new HashMap<>();
		params.put("category", category);
		params.put("page", String.valueOf(page));

		HelperProductPage helperPage = restTemplate.getForObject(url + "/products/categories/{category}/{page}",
				HelperProductPage.class, params);

		return helperPage;
	}

}
