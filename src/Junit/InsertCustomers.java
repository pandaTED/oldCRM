package Junit;

import java.util.Date;
import java.util.UUID;

import cn.panda.dao.CustomerDao;
import cn.panda.dao.impl.CustomerDaoImpl;
import cn.panda.domain.Customer;

public class InsertCustomers extends CustomerDaoImpl {

	public static void main(String[] args) {
		
		CustomerDao dao = new CustomerDaoImpl();
		Customer c = new Customer();
		
		for(int i=0;i<99;i++){
		String id= generateID();
		String name="������"+i+i;
		String gender="��";
		Date birthday= new Date(86, 02, 27);
		String cellphone="18325484600";
		String email="aa@bb.com";
		String preference="�ݹ�����������";
		String type = "VIP";
		String description ="˧��һ��˧��һ��˧��һ��˧��һ��˧��һ��";
		c.setBirthday(birthday);
		c.setCellphone(cellphone);
		c.setDescription(description);
		c.setEmail(email);
		c.setGender(gender);
		c.setId(id);
		c.setName(name);
		c.setPreference(preference);
		c.setType(type);
		
		dao.add(c);
		
		}
		
	}
	
	public static String generateID(){
		return UUID.randomUUID().toString();
	}

	
	
}
