package com.sangoc.dao;

import java.util.List;

import com.sangoc.model.UserModel;

public interface IUserDAO extends GenericDAO {
	List<UserModel> findAll();
}
