package com.sangoc.dao;

import java.util.List;

import com.sangoc.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(RowMapper<T> rowMapper, String sql, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(String sql, Object... parameters);
}

	
