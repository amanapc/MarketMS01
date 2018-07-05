package com.qfedu.shop.dao;

import java.sql.SQLException;
import java.util.List;

import com.qfedu.shop.pojo.Provider;

public interface ProviderDao {

	// 查询所有供应商讯息
	List<Provider> selectAll(Class<Provider> c) throws SQLException;
	
	Provider selectById(String id, Class<Provider> c) throws SQLException;
	
	int add(Provider p) throws SQLException;
	
	int update(Provider p) throws SQLException;
	
	int deleteById(String id) throws SQLException;
}
