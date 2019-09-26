package com.hfut.edu.databasecoursedesignfoods.service;

import com.hfut.edu.databasecoursedesignfoods.domain.RecordSimple;
import com.hfut.edu.databasecoursedesignfoods.domain.RecordWhole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecordService {

    public List<RecordWhole> getByCustomerId(Integer id);

    public List<RecordWhole> getByCustomerName(String name);

    public List<RecordWhole> getByShopId(Integer id);

    public boolean insertOneRecord(RecordSimple simple, List<String> ids);

    public RecordWhole getById(Integer id);
}
