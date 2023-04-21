package com.sangoc.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
T mapRow(ResultSet resultset);
}
