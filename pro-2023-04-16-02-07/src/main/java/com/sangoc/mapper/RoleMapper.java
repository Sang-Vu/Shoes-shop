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
			role.setCreatedDate(resultset.getTimestamp("createdDate"));
			role.setCreatedBy(resultset.getString("createdBy"));
			if (resultset.getTimestamp("modifiedDate") != null) {
				role.setModifiedDate(resultset.getTimestamp("modifiedDate"));
			}
			if (resultset.getString("modifiedBy") != null) {
				role.setModifiedBy(resultset.getString("modifiedBy"));
			}

			return role;
		} catch (SQLException e) {
			return null;
		}
	}
}
