package com.sangoc.dao.impl;

import java.util.List;

import com.sangoc.dao.IProductDAO;
import com.sangoc.mapper.ProductMapper;
import com.sangoc.model.ProductModel;

public class ProductDAO extends AbtractDAO<ProductModel> implements IProductDAO {
	@Override
	public List<ProductModel> findByCategoryId(Long categoryId, int status) {
		String sql = "SELECT * FROM product WHERE categoryId = ? AND status = ?";
		return query(new ProductMapper(), sql, categoryId, status);
	}

	@Override
	public Long save(ProductModel product) {
		StringBuilder sql = new StringBuilder(
				"INSERT INTO product (name, categoryId, price, status,createdDate, createdBy) ");
		sql.append("VALUES(?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), product.getName(), product.getCategoryId(), product.getPrice(),
				product.getStatus(), product.getCreatedDate(), product.getCreatedBy());
	}

	@Override
	public ProductModel findOne(Long id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		List<ProductModel> product = query(new ProductMapper(), sql, id);
		return product.isEmpty() ? null : product.get(0);
	}

	@Override
	public void update(ProductModel product) {
		StringBuilder sql = new StringBuilder("UPDATE product SET name = ?, categoryId = ?, ");
		sql.append("price = ?, status = ?, ");
		sql.append("createdDate = ?, createdBy = ?, ");
		sql.append("modifiedDate = ?, modifiedBy = ? WHERE id = ?");
		update(sql.toString(), product.getName(), product.getCategoryId(), product.getPrice(), product.getStatus(),
				product.getCreatedDate(), product.getCreatedBy(), product.getModifiedDate(), product.getModifiedBy(),
				product.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM product WHERE id = ?";
		update(sql, id);

	}
}
