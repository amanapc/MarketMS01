package com.qfedu.shop.tools;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtil {
	
	private static DataSource dataSource;
	
	public static DataSource getDataSource() {
		if (dataSource == null) {
			synchronized (DataSourceUtil.class) {
				if (dataSource == null) {
					dataSource =  new ComboPooledDataSource();
				}
			}
		}
		
		return dataSource;
	}
	
	public static DataSource ComboDataSource() {
		if (dataSource == null) {
			synchronized (DataSourceUtil.class) {
				if (dataSource == null) {
					dataSource = new ComboPooledDataSource();
				}
			}
		}
		
		return dataSource;
	}
	
	
	
	public static DataSource CommonsDataSource(String config) throws Exception {
		if (dataSource == null) {
			synchronized (DataSourceUtil.class) {
				if (dataSource == null) {
					Properties prop = new Properties();
					prop.load(DataSourceUtil.class.getClassLoader().getResourceAsStream(config));
					dataSource = BasicDataSourceFactory.createDataSource(prop);
				}
			}
		}
		
		return dataSource;
	}
}
