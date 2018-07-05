package com.qfedu.shop.tools;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class DbUtil {
	
	
	public static int update(String sql, Object[] objs) throws SQLException {

		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

		
		return qr.update(sql, objs);

	}

	public static <T> List<T> queryObject(String sql, Object[] objs, Class<T> c) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

		return objs == null ? qr.query(sql, new BeanListHandler<T>(c)) : qr.query(sql, new BeanListHandler<T>(c), objs);

	}
	


	public static List<Map<String, Object>> queryMap(String sql, Object[] objs) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

		return objs == null ? qr.query(sql, new MapListHandler()) : qr.query(sql, new MapListHandler(), objs);

	}
	

	

}
