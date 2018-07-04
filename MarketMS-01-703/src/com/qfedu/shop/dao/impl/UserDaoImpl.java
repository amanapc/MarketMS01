package com.qfedu.shop.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qfedu.shop.dao.UserDao;
import com.qfedu.shop.tools.DbUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public Map<String, Object> login(String username, String password) throws SQLException {
		String sql = "select * from user where `username`= ? and `password`= ?";
		List<Map<String, Object>> list = DbUtil.queryMap(sql, new String[] {username, password});
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public List<Map<String, Object>> selectAllUser() throws SQLException {
		String sql = "select * from user";
		return DbUtil.queryMap(sql, null);
	}

	@Override
	public Map<String, Object> selectUserByName(String username) throws SQLException {
		String sql = "select * from user where `username`= ?";
		List<Map<String, Object>> list = DbUtil.queryMap(sql, new String[] {username});
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

}
