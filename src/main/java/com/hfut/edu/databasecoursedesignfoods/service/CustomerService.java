package com.hfut.edu.databasecoursedesignfoods.service;

import com.hfut.edu.databasecoursedesignfoods.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    public Customer getByName(String name);

    public Boolean register(Customer customer);
}
