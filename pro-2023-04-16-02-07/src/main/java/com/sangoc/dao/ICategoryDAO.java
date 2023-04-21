package com.sangoc.dao;

import java.util.List;

import com.sangoc.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	CategoryModel save(CategoryModel category);
}
