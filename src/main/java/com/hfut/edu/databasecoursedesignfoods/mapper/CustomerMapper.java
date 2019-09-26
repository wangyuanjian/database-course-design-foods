package com.hfut.edu.databasecoursedesignfoods.mapper;

import com.hfut.edu.databasecoursedesignfoods.domain.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {

    public Customer getByName(String name);

    public boolean register(Customer customer);
}
