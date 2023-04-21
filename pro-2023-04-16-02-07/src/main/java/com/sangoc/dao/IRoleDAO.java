package com.sangoc.dao;

import java.util.List;

import com.sangoc.model.RoleModel;

public interface IRoleDAO extends GenericDAO {
	List<RoleModel> findAll();
}
