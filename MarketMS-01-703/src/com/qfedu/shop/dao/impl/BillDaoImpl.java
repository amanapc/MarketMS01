package com.qfedu.shop.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qfedu.shop.dao.BillDao;
import com.qfedu.shop.tools.DbUtil;

public class BillDaoImpl implements BillDao {

	@Override
	public int add(Map<String, String[]> bill) throws SQLException {
		String sql = "insert into bill (`gname`,`gcount`,`price`,`ispaied`,`gdesc`,`pid`,`billtime`) value(?,?,?,?,?,?,now())";

		Object[] params = new Object[] {bill.get("gname")[0],bill.get("gcount")[0],bill.get("price")[0],bill.get("ispaied")[0],bill.get("gdesc")[0],bill.get("pid")[0]};
		return DbUtil.update(sql, params);
	}

	@Override
	public List<Map<String, Object>> selectAll() throws SQLException {
		String sql = "select b.*,p.pname from bill b left join provider p on b.pid=p.id;";
		return DbUtil.queryMap(sql, null);
	}
	
	

	@Override
	public Map<String, Object> selectByBillId(String billId) throws SQLException {
		String sql = "select b.*,p.pname from bill b left join provider p on b.pid=p.id where b.id=?;";
		return DbUtil.queryMap(sql, new String[] { billId }).get(0);
	}

	@Override
	public List<Map<String, Object>> selectByProviderId(String providerId) throws SQLException {
		String sql = "select b.*,p.pname from bill b left join provider p on b.pid=p.id where b.pid=?;";
		return DbUtil.queryMap(sql, new String[] { providerId });
	}

	@Override
	public int update(Map<String, String[]> bill) throws SQLException {
		String sql = "update bill set `gname`=?,`gcount`=?,`price`=?,`ispaied`=?,`gdesc`=?,`pid`=? where id=?";

		Object[] params = new Object[] {bill.get("gname")[0],bill.get("gcount")[0],bill.get("price")[0],bill.get("ispaied")[0],bill.get("gdesc")[0],bill.get("pid")[0],bill.get("id")[0]};
		return DbUtil.update(sql, params);
	}

	@Override
	public int deleteById(String id) throws SQLException {
		String sql = "delete from bill where id = ?";
		return DbUtil.update(sql, new String[] {id});
	}

	@Override
	public int deleteById(String[] bills) throws SQLException {
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectByPaiedStatus(String ispaied) throws SQLException {
		String sql = "select * from bill where `ispaied` = ?";
		return DbUtil.queryMap(sql, new String[] {ispaied});
	}

}
