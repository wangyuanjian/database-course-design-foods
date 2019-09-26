package com.hfut.edu.databasecoursedesignfoods.service.impl;

import com.hfut.edu.databasecoursedesignfoods.domain.Food;
import com.hfut.edu.databasecoursedesignfoods.domain.RecordSimple;
import com.hfut.edu.databasecoursedesignfoods.domain.RecordWhole;
import com.hfut.edu.databasecoursedesignfoods.mapper.FoodMapper;
import com.hfut.edu.databasecoursedesignfoods.mapper.RecordMapper;
import com.hfut.edu.databasecoursedesignfoods.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<RecordWhole> getByCustomerId(Integer id) {
        List<RecordSimple> simples = recordMapper.getByCustomerId(id);
        List<RecordWhole> wholes = new ArrayList<>();
        for(RecordSimple simple : simples){
            wholes.add(convertsTo(simple));
        }
        return wholes;
    }

    @Override
    public List<RecordWhole> getByCustomerName(String name) {
        List<RecordSimple> simples = recordMapper.getByCustomerName(name);
        List<RecordWhole> wholes = new ArrayList<>();
        for(RecordSimple simple : simples){
            wholes.add(convertsTo(simple));
        }
        return wholes;
    }

    @Override
    public List<RecordWhole> getByShopId(Integer id) {
        List<RecordSimple> simples = recordMapper.getByShopId(id);
        List<RecordWhole> wholes = new ArrayList<>();
        for(RecordSimple simple : simples){
            wholes.add(convertsTo(simple));
        }
        return wholes;
    }

    @Override
    @Transactional
    public boolean insertOneRecord(RecordSimple simple, List<String> ids) {
        StringBuffer buffer = new StringBuffer();
        double price = 0;

        for(int i = 1; i < ids.size(); i++){
            if(i == ids.size()-1){
                buffer.append(ids.get(i));
            }else {
                buffer.append(ids.get(i) + "|");
            }
        }

        for(int i = 1; i < ids.size(); i++){
            price += (foodMapper.getById(Integer.parseInt(ids.get(i))).getMoney());
        }
        simple.setOrder(buffer.toString());
        simple.setMoney(price);

        Date date = new Date();
        DateFormat df2 = DateFormat.getDateTimeInstance();
        simple.setTime(df2.format(date));
        return recordMapper.insertOneRecord(simple);
    }

    @Override
    public RecordWhole getById(Integer id) {
        RecordSimple simple = recordMapper.getById(id);
        return convertsTo(simple);
    }

    public RecordWhole convertsTo(RecordSimple simple){
        String[] orders = simple.getOrder().split("\\|");
        Integer[] ids = new Integer[orders.length];
        for(int i = 0; i < ids.length; i++){
            ids[i] = Integer.parseInt(orders[i]);
        }
        List<Food> foods = foodMapper.getByIds(ids);
        return new RecordWhole(simple.getId(), simple.getCustomerId(), simple.getShopId(),
                simple.getShopName(), simple.getTime(), foods, simple.getMoney());
    }
}














