package com.sangoc.dao.impl;

import java.util.List;

import com.sangoc.dao.ICategoryDAO;
import com.sangoc.mapper.CategoryMapper;
import com.sangoc.model.CategoryModel;

public class CategoryDAO extends AbtractDAO<CategoryModel> implements ICategoryDAO {
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(new CategoryMapper(), sql);
	}
	
	@Override
	public CategoryModel save(CategoryModel category) {
		return null;
	}
}
