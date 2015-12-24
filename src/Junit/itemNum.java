package Junit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.panda.domain.Customer;
import cn.panda.exception.DaoException;
import cn.panda.utils.JdbcUtils;
import cn.panda.domain.Customer;



/*@Test
public itemNum(){
	
	PageInfo pi = new PageInfo();
	int itemNum = pi.getItemNum();
	int pageNum = pi.getPageNum();
	int currentPage =pi.getCurrentPage();	
	int itemNumPerPage =pi.getItemPerPageNum();
	

	System.out.println("总计："+itemNum+"条数据" );
	System.out.println("每页显示："+itemNumPerPage+"条数据");
	System.out.println("总计："+pageNum+"页");
	System.out.println("当前页："+currentPage);

	
	pi.setItemPerPageNum(20);
	int itemNumPerPage2 =pi.getItemPerPageNum();
	System.out.println("每页显示："+itemNumPerPage2+"条数据");
	int pageNum1 = pi.getPageNum();
	System.out.println("总计："+pageNum1+"页");
	
}*/
public class itemNum{
	

	@Test
	public void getToShow() {		//获取所有客户
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	int startPage =1;
	int itemPerPageNum=10;
	try {
		conn = JdbcUtils.getConnection();
		String sql = "select * from customer limit ?,?";
		st = conn.prepareStatement(sql);
		st.setInt(1, startPage);
		st.setInt(2, itemPerPageNum);
		rs = st.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			Customer c = new Customer();
			c.setBirthday(rs.getDate("birthday"));
			c.setCellphone(rs.getString("cellphone"));
			c.setDescription(rs.getString("description"));
			c.setEmail(rs.getString("email"));
			c.setGender(rs.getString("gender"));
			c.setName(rs.getString("name"));
			c.setPreference(rs.getString("preference"));
			c.setType(rs.getString("type"));
			c.setId(rs.getString("id"));
			list.add(c);
		}
//		return list;

	} catch (Exception e) {
		throw new DaoException(e);
	} finally {
		JdbcUtils.release(conn, st, rs);
	}

	}
}

