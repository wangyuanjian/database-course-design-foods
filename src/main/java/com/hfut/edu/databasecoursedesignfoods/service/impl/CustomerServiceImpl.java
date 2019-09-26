package com.hfut.edu.databasecoursedesignfoods.service.impl;

import com.hfut.edu.databasecoursedesignfoods.common.MyEncrypt;
import com.hfut.edu.databasecoursedesignfoods.domain.Customer;
import com.hfut.edu.databasecoursedesignfoods.mapper.CustomerMapper;
import com.hfut.edu.databasecoursedesignfoods.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer getByName(String name) {
        return customerMapper.getByName(name);
    }

    @Override
    public Boolean register(Customer customer) {
        if(customer.getCustomerName().equalsIgnoreCase("admin")){
            return false;
        }
        customer.setPassword(MyEncrypt.md5(customer.getPassword()).substring(1, 16));
        return  customerMapper.register(customer);
//        return null;
    }
}
