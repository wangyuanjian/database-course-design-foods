package com.hfut.edu.databasecoursedesignfoods.service;

import com.hfut.edu.databasecoursedesignfoods.domain.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    public Food getById(Integer id);

    public Food getByName(String name);

    public List<Food> getByIds(Integer[] ids);

    public boolean updateById(Food food);

    public List<String> getAllFoodNames();
}
