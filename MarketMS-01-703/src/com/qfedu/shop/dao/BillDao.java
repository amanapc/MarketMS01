package com.qfedu.shop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BillDao {
	
	/**
	 * 添加账单
	 * @param bill
	 * @return
	 * @throws SQLException
	 */
	int add(Map<String, String[]> bill) throws SQLException;
	
	/**
	 * 查询所有表单
	 */
	List<Map<String, Object>> selectAll() throws SQLException;
	
	/**
	 * 根据账单id获取账单数据
	 * 
	 */
	Map<String, Object> selectByBillId(String id) throws SQLException;
	
	/**
	 * 根据付款状态查询账单
	 * @param ispaid
	 * @return
	 * @throws SQLException
	 */
	List<Map<String, Object>> selectByPaiedStatus(String ispaid) throws SQLException;
	
	/**
	 * 查询对应供应商的的所有账单
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	List<Map<String, Object>> selectByProviderId(String id) throws SQLException;
	
	/**
	 * 更新账单
	 */
	int update(Map<String, String[]> bill) throws SQLException;
	
	/**
	 * 删除单个账单
	 * @param id
	 */
	int deleteById(String id) throws SQLException;
	
	/**
	 * 删除多个账单
	 * @param bills 存储多个账单的id数组
	 */
	int deleteById(String[] bills) throws SQLException;


	
}
