package com.sangoc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sangoc.dao.GenericDAO;
import com.sangoc.mapper.RowMapper;

public class AbtractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/pro_2023_04_16_02_07";
			String user = "root";
			String password = "";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(RowMapper<T> rowMapper, String sql, Object... parameters) {
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Connection conn = null;
		List<T> result = new ArrayList<>();
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			setParameter(statement, parameters);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				result.add(rowMapper.mapRow(resultset));
			}
			return result;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		PreparedStatement statement = null;

		Connection conn = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException ey) {
				ey.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Connection conn = null;
		Long id = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultset = statement.getGeneratedKeys();
			if (resultset.next()) {
				id = resultset.getLong(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}

			} catch (SQLException ey) {
				ey.printStackTrace();
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			int index = 0;
			for (int i = 0; i < parameters.length; i++) {
				index = i + 1;
				if (parameters[i] instanceof Long) {
					statement.setLong(index, (Long) parameters[i]);
				} else if (parameters[i] instanceof Integer) {
					statement.setInt(index, (Integer) parameters[i]);
				} else if (parameters[i] instanceof String) {
					statement.setString(index, (String) parameters[i]);
				} else if (parameters[i] instanceof Boolean) {
					statement.setBoolean(index, (Boolean) parameters[i]);
				} else if (parameters[i] instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameters[i]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
