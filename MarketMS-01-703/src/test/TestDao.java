package test;

import java.sql.SQLException;
import java.util.Map;

import com.qfedu.shop.dao.UserDao;
import com.qfedu.shop.dao.impl.UserDaoImpl;

public class TestDao {

	public static void main(String[] args) {
		
		UserDao userDao = new UserDaoImpl();
		
		try {
			Map<String, Object> user = userDao.selectUserByName("yong");
			
			System.out.println(user.get("password"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
