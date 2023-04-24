package com.sangoc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sangoc.model.ProductModel;

public class ProductMapper  implements RowMapper<ProductModel> {
	@Override
	public ProductModel mapRow(ResultSet resultset) {
		try {
			ProductModel product = new ProductModel();
			product.setId(resultset.getLong("id"));
			product.setName(resultset.getString("name"));
			product.setPrice(resultset.getLong("price"));
			product.setCategoryId(resultset.getLong("categoryId"));
			product.setStatus(resultset.getInt("status"));
			product.setCreatedDate(resultset.getTimestamp("createdDate"));
			product.setCreatedBy(resultset.getString("createdBy"));
			if (resultset.getTimestamp("modifiedDate") != null) {
				product.setModifiedDate(resultset.getTimestamp("modifiedDate"));
			}
			if (resultset.getString("modifiedBy") != null) {
				product.setModifiedBy(resultset.getString("modifiedBy"));
			}
			
			return product;
		}
		catch(SQLException e) {
			return null;
		}
	}
}
