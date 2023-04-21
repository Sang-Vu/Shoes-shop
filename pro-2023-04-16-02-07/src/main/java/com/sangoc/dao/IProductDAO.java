package com.sangoc.dao;

import java.util.List;

import com.sangoc.model.ProductModel;

public interface IProductDAO extends GenericDAO<ProductModel> {
	List<ProductModel> findByCategoryId(Long categoryId, int status);
	Long save(ProductModel product);
	
}
