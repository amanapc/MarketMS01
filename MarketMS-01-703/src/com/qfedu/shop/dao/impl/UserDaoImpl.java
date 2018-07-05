package com.qfedu.shop.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.qfedu.shop.dao.UserDao;
import com.qfedu.shop.pojo.User;
import com.qfedu.shop.tools.DataSourceUtil;
import com.qfedu.shop.tools.DbUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public Map<String, Object> login(String username, String password) throws SQLException {
		String sql = "select * from user where `username`= ? and `password`= ?";
		List<Map<String, Object>> list = DbUtil.queryMap(sql, new String[] { username, password });
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
		List<Map<String, Object>> list = DbUtil.queryMap(sql, new String[] { username });
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public List<User> selectAllUser(Class<User> c) throws SQLException {

		return DbUtil.queryObject("select * from user", null, c);
	}

	@Override
	protected void finalize() {
		System.out.println(this + "XXXXXXXXXXXXXXXX Garbage Collected");
	}

	@Override
	public int addUser(User user) throws SQLException {
		Object[] params = { user.getUsername(), user.getPassword(), user.getGender(), user.getAge(), user.getTel(),
				user.getAddress(), user.getIssupper() };
		return DbUtil.update("insert into user values(null, ?, ?, ?, ?, ?, ?, ?)", params);
	}

	@Override
	public User selectUserById(String id) throws SQLException {

		return DbUtil.queryObject("select * from user where id= ?", new String[] { id }, User.class).get(0);
	}

	@Override
	public int updateUser(User user) throws SQLException {
		return DbUtil.update(
				"update user set `username`= ?, `password`=?,`gender`=?,`age`=?,`tel`=?,`address`=?,`issupper`=? where `id`=?",
				new Object[] { user.getUsername(), user.getPassword(), user.getGender(), user.getAge(), user.getTel(),
						user.getAddress(), user.getIssupper(), user.getId() });
	}

	@Override
	public int deleteUser(String id) throws SQLException {
		
		return DbUtil.update("delete from user where `id`=?", new String[] {id});
	}

}
