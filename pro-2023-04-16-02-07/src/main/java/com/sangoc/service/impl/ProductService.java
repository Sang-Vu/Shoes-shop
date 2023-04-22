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
		Long id = productDA.save(product);
		return productDA.findOne(id);
	}

	@Override
	public ProductModel update(ProductModel product) {
		ProductModel oldProduct = productDA.findOne(product.getId());
		product.setCreatedBy(oldProduct.getCreatedBy());
		product.setCreatedDate(oldProduct.getCreatedDate());
		productDA.update(product);
		return productDA.findOne(product.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			productDA.delete(id);
		}
	}
	
	
}
