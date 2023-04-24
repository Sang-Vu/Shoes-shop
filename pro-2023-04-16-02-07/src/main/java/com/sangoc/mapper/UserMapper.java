package com.sangoc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sangoc.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {
	@Override
	public UserModel mapRow(ResultSet resultset) {
		try {
			UserModel user = new UserModel();
			user.setId(resultset.getLong("id"));
			user.setName(resultset.getString("name"));
			user.setEmail(resultset.getString("email"));
			user.setAddress(resultset.getString("address"));
			user.setPhone(resultset.getLong("phone"));
			user.setCreatedDate(resultset.getTimestamp("createdDate"));
			user.setCreatedBy(resultset.getString("createdBy"));
			if (resultset.getTimestamp("modifiedDate") != null) {
				user.setModifiedDate(resultset.getTimestamp("modifiedDate"));
			}
			if (resultset.getString("modifiedBy") != null) {
				user.setModifiedBy(resultset.getString("modifiedBy"));
			}

			return user;
		} catch (SQLException e) {
			return null;
		}
	}
}
