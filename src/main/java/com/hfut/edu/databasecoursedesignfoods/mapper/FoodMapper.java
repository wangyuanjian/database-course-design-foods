package com.hfut.edu.databasecoursedesignfoods.mapper;

import com.hfut.edu.databasecoursedesignfoods.domain.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {

    public Food getById(Integer id);

    public Food getByName(String name);

    public List<Food> getByIds(Integer[] ids);

    public boolean updateById(Food food);

    public List<String> getAllFoodNames();
}
