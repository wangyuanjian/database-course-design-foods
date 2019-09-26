package com.hfut.edu.databasecoursedesignfoods.service;

import com.hfut.edu.databasecoursedesignfoods.domain.Food;
import com.hfut.edu.databasecoursedesignfoods.domain.Income;
import com.hfut.edu.databasecoursedesignfoods.domain.ShopSimple;
import com.hfut.edu.databasecoursedesignfoods.domain.ShopWhole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ShopService {
    public ShopWhole getById(Integer id);

    public List<ShopWhole> getShops();

    public List<ShopWhole> getByAreaId(Integer id);

    public boolean updateShopInfo(ShopSimple simple);

    public ShopWhole convertsTo(ShopSimple shopSimple);

    public Double calHistoryIncome(Integer id);

    public void calHistoryIncomeByProcedure(Map<String, Object> map);

    public boolean addOneFood(Food food, Integer id);

    public List<ShopWhole> getShopsByFoodName(String foodName);
}

