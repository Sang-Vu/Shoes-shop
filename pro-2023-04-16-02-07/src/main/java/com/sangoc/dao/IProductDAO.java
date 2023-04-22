package com.sangoc.dao;

import java.util.List;

import com.sangoc.model.ProductModel;

public interface IProductDAO extends GenericDAO<ProductModel> {
	ProductModel findOne(Long id);
	List<ProductModel> findByCategoryId(Long categoryId, int status);
	Long save(ProductModel product);
	void update(ProductModel product);
	void delete(long id);
}
