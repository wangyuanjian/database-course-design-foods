package com.hfut.edu.databasecoursedesignfoods.service.impl;

import com.hfut.edu.databasecoursedesignfoods.domain.Food;
import com.hfut.edu.databasecoursedesignfoods.mapper.FoodMapper;
import com.hfut.edu.databasecoursedesignfoods.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public Food getById(Integer id) {
        return foodMapper.getById(id);
    }

    @Override
    public Food getByName(String name) {
        return foodMapper.getByName(name);
    }

    @Override
    public List<Food> getByIds(Integer[] ids) {
        return foodMapper.getByIds(ids);
    }

    @Override
    @Transactional
    public boolean updateById(Food food) {
        return foodMapper.updateById(food);
    }

    @Override
    public List<String> getAllFoodNames() {
        return foodMapper.getAllFoodNames();
    }
}
