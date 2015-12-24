package cn.panda.service;

import java.util.List;

import cn.panda.domain.Customer;
import cn.panda.domain.PageBean;
import cn.panda.domain.UserRequest;

public interface BusinessService {

	void addCustomer(Customer c);

	void updateCustomer(Customer c);

	void deleteCustomer(String id);

	Customer findCustomer(String id);

//	List<Customer> getAllCustomer();
	
	 PageBean getPageBean(UserRequest userRequest);

}