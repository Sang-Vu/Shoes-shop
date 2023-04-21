package com.sangoc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sangoc.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel> {
	@Override
	public RoleModel mapRow(ResultSet resultset) {
		try {
			RoleModel role = new RoleModel();
			role.setId(resultset.getLong("id"));
			role.setName(resultset.getString("name"));
			role.setCode(resultset.getString("name"));
			return role;
		}
		catch(SQLException e) {
			return null;
		}
	}
}
