package com.qfedu.shop.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qfedu.shop.dao.ProviderDao;
import com.qfedu.shop.pojo.Provider;
import com.qfedu.shop.tools.DbUtil;

public class ProviderDaoImpl implements ProviderDao {

	@Override
	public List<Provider> selectAll(Class<Provider> c) throws SQLException {
		String sql = "select * from provider";
		return DbUtil.queryObject(sql, null, c);
	}

	@Override
	public Provider selectById(String id, Class<Provider> c) throws SQLException {
		String sql = "select * from provider where `id`= ?";
		return DbUtil.queryObject(sql, new String[] {id}, c).get(0);
	}

	@Override
	public int add(Provider p) throws SQLException {
		String sql = "insert into provider value(null,?,?,?,?,?)";
		Object[] params = new Object[] {p.getPname(),p.getPdesc(),p.getContact(),p.getTel(),p.getAddress()};
		return DbUtil.update(sql, params);
	}

	@Override
	public int update(Provider p) throws SQLException {
		String sql = "update provider set `pname`=?,`pdesc`=?,`contact`=?,`tel`=?,`address`=? where `id`=?";
		Object[] params = new Object[] {p.getPname(),p.getPdesc(),p.getContact(),p.getTel(),p.getAddress(),p.getId()};
		return DbUtil.update(sql, params);
	}

	@Override
	public int deleteById(String id) throws SQLException {
		String sql = "delete from provider where `id`=?";
		return DbUtil.update(sql, new String[] {id});
	}

	@Override
	public List<Map<String, Object>> selectSimple() throws SQLException {
		String sql = "select id, pname from provider";
		return DbUtil.queryMap(sql, null);
	}

}
