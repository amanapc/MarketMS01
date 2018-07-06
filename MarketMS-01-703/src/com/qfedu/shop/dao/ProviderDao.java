package com.qfedu.shop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qfedu.shop.pojo.Provider;

public interface ProviderDao {

	/**
	 * 查询所有供应商完整讯息
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	List<Provider> selectAll(Class<Provider> c) throws SQLException;
	
	/**
	 * 查询所有供应商的简略信息（id和name）
	 * @return
	 * @throws SQLException
	 */
	List<Map<String, Object>> selectSimple() throws SQLException;
	
	/**
	 * 根据id获取供应商的完整讯息
	 * @param id
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	Provider selectById(String id, Class<Provider> c) throws SQLException;
	
	/**
	 * 添加新的供应商
	 * @param p
	 * @return
	 * @throws SQLException
	 */
	int add(Provider p) throws SQLException;
	
	/**
	 * 更新供应商信息，完整更新
	 * @param p
	 * @return
	 * @throws SQLException
	 */
	int update(Provider p) throws SQLException;
	
	/**
	 * 删除对应id的供应商数据
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteById(String id) throws SQLException;
}
