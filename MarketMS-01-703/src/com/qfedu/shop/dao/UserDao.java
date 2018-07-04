package com.qfedu.shop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao {
	
	
	// 用户登录查询
	/**
	 * 验证用户登录，如果用户名与密码匹配，返回用户完整信息，如果不匹配，返回null
	 * @param username
	 * @param password
	 * @return 如果用户名与密码匹配，返回用户完整信息，如果不匹配，返回null
	 * @throws SQLException
	 */
	Map<String, Object> login(String username, String password) throws SQLException;
	// 查询所有用户
	List<Map<String, Object>> selectAllUser() throws SQLException;
	// 按照用户名查询
	Map<String, Object> selectUserByName(String username) throws SQLException;

}
