package com.qfedu.shop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qfedu.shop.pojo.User;

public interface UserDao {
	
	// UserDao单例实现
	// 实现类应提供一个方法提供单实例
//	UserDao getInstance();
	
	// 用户登录查询
	/**
	 * 验证用户登录，如果用户名与密码匹配，返回用户完整信息，如果不匹配，返回null
	 * @param username
	 * @param password
	 * @return 如果用户名与密码匹配，返回用户完整信息，如果不匹配，返回null
	 * @throws SQLException
	 */
	Map<String, Object> login(String username, String password) throws SQLException;
	

	/**
	 * 查询出所有用户信息
	 * @return
	 * @throws SQLException
	 */
	List<Map<String, Object>> selectAllUser() throws SQLException;
	
	/**
	 * 查询所有的用户信息
	 * 
	 * @param c User类的Class类对象
	 * @return User对象的List集合
	 * @throws SQLException
	 */
	List<User> selectAllUser(Class<User> c) throws SQLException;
	

	
	Map<String, Object> selectUserByName(String username) throws SQLException;
	
	/**
	 * 添加新用户信息，用户id默认自增
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int addUser(User user) throws SQLException;


	/**
	 * 根据给定的用户id查询用户信息
	 * @param id
	 * @return 存储对应用户信息的User对象
	 * @throws SQLException
	 */
	User selectUserById(String id) throws SQLException;
	
	/**
	 * 更新现有用户的信息
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int updateUser(User user) throws SQLException;
	
	/**
	 * 删除指定id的用户
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteUser(String id) throws SQLException;

}
