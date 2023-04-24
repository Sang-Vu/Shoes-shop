package com.sangoc.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
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
		product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		product.setCreatedBy("");
		Long id = productDA.save(product);
		return productDA.findOne(id);
	}

	@Override
	public ProductModel update(ProductModel product) {
		ProductModel oldProduct = productDA.findOne(product.getId());
		if(oldProduct == null) {
			return null;
		}
		product.setCreatedBy(oldProduct.getCreatedBy());
		product.setCreatedDate(oldProduct.getCreatedDate());
		product.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		product.setModifiedBy("");
		productDA.update(product);
		return productDA.findOne(product.getId());
	}

	@Override
	public List<ProductModel> delete(long[] ids) {
		List<ProductModel> products = new ArrayList<>();
		for(long id : ids) {
			productDA.delete(id);
		}
		for(long id : ids) {
			if(productDA.findOne(id) != null){
				products.add(productDA.findOne(id));
			}	
		}
		return products;
	}

	@Override
	public ProductModel findOne(Long id) {
		return productDA.findOne(id);
	}
	
	
}
