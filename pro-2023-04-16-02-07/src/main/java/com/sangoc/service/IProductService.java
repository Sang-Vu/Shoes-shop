package com.sangoc.service;

import java.util.List;

import com.sangoc.model.ProductModel;

public interface IProductService {
	List<ProductModel> findByCategoryId(Long categoryId, int status);
	ProductModel findOne(Long id);
	ProductModel save(ProductModel product);
	ProductModel update(ProductModel product);
	List<ProductModel> delete(long[] ids);
}
