package com.sangoc.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.sangoc.dao.IProductDAO;
import com.sangoc.model.ProductModel;
import com.sangoc.service.IProductService;

public class ProductService implements IProductService {
	@Inject
	private IProductDAO productDA;
	
	@Override
	public List<ProductModel> findByCategoryId(Long categoryId, int status) {
		return productDA.findByCategoryId(categoryId, status);
	}
	
	@Override
	public ProductModel save(ProductModel product) {
		productDA.save(product);
		return null;
	}
}
