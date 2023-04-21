package com.sangoc.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.sangoc.dao.ICategoryDAO;
import com.sangoc.model.CategoryModel;
import com.sangoc.service.ICategoryService;

public class CategoryService implements ICategoryService {
	@Inject
	private ICategoryDAO categoryDA;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDA.findAll();
	}
}
