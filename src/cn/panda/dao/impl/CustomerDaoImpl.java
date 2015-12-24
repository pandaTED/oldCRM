package cn.panda.dao.impl;

import cn.panda.dao.CustomerDao;
import cn.panda.domain.Customer;
import cn.panda.domain.RequestResult;
import cn.panda.exception.DaoException;
import cn.panda.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 运鹏 on 2015/10/31 0031.
 */
public class CustomerDaoImpl implements CustomerDao {

	public void add(Customer c) {     //增加客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into customer (id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, c.getId());
			st.setString(2, c.getName());
			st.setString(3, c.getGender());
			st.setDate(4, new java.sql.Date(c.getBirthday().getTime()));
			st.setString(5, c.getCellphone());
			st.setString(6, c.getEmail());
			st.setString(7, c.getPreference());
			st.setString(8, c.getType());
			st.setString(9, c.getDescription());
			st.executeUpdate();

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}

	}

	public void update(Customer c) {     //更新客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id =?";
			st = conn.prepareStatement(sql);
			st.setString(1, c.getName());
			st.setString(2, c.getGender());
			st.setDate(3, new java.sql.Date(c.getBirthday().getTime()));
			st.setString(4, c.getCellphone());
			st.setString(5, c.getEmail());
			st.setString(6, c.getPreference());
			st.setString(7, c.getType());
			st.setString(8, c.getDescription());
			st.setString(9, c.getId());
			st.executeUpdate();

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}


	
	public void delete(String id) {     //删除客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from customer where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}



	public Customer find(String id) {       //查询客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer where id =?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
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
				return c;
			}
			return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}


	
/*	public List<Customer> getAll() {		//获取所有客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer";
			st = conn.prepareStatement(sql);
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
			return list;

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}*/


	public RequestResult getResult(int startindex,int itemPerPageNum) {		//获取所有客户
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		RequestResult requestResult = new RequestResult();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, startindex);
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
			
			requestResult.setCustomerList(list);
			
			sql = "select count(*) from customer";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
			int itemNum = rs.getInt(1);
			requestResult.setItemNum(itemNum);
			}
			return requestResult;

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

}
