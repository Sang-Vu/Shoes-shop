package com.sangoc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sangoc.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {
	@Override
	public CategoryModel mapRow(ResultSet resultset) {
		try {
			CategoryModel category = new CategoryModel();
			category.setId(resultset.getLong("id"));
			category.setName(resultset.getString("name"));
			category.setCode(resultset.getString("code"));
			return category;
		}
		catch(SQLException e) {
			return null;
		}
	}
}
