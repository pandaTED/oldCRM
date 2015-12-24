package cn.panda.dao;

import java.util.List;

import cn.panda.domain.Customer;
import cn.panda.domain.RequestResult;

public interface CustomerDao {

	void add(Customer c);

	void update(Customer c);

	void delete(String id);

	Customer find(String id);

//	List<Customer> getAll();

	RequestResult getResult(int startindex,int itemPerPageNum);



}