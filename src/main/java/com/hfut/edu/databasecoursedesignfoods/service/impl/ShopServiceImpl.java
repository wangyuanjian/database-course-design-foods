package com.hfut.edu.databasecoursedesignfoods.service.impl;

import com.hfut.edu.databasecoursedesignfoods.domain.*;
import com.hfut.edu.databasecoursedesignfoods.mapper.FoodMapper;
import com.hfut.edu.databasecoursedesignfoods.mapper.ShopMapper;
import com.hfut.edu.databasecoursedesignfoods.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private FoodMapper foodMapper;

    /**
     * 将ShopSimple==》ShopWhole
     * @param id
     * @return
     */
    @Override
    public ShopWhole getById(Integer id) {
        ShopSimple shopSimple = shopMapper.getById(id);
        return convertsTo(shopSimple);
    }

    @Override
    public List<ShopWhole> getShops() {
        List<ShopSimple> shops = shopMapper.getShops();
        List<ShopWhole> wholes = new ArrayList<>();
        for(ShopSimple shopSimple : shops){
            wholes.add(convertsTo(shopSimple));
        }
        return wholes;
    }

    @Override
    public List<ShopWhole> getByAreaId(Integer id) {
        List<ShopSimple> simples = shopMapper.getByAreaId(id);
        List<ShopWhole> wholes = new ArrayList<>();
        for(ShopSimple shopSimple : simples){
            wholes.add(convertsTo(shopSimple));
        }
        return wholes;
    }

    @Override
    public boolean updateShopInfo(ShopSimple simple) {
        return shopMapper.updateShopInfo(simple);
    }

    @Override
    public ShopWhole convertsTo(ShopSimple shopSimple){
        String[] goods = shopSimple.getGoods().split("\\|");
//        System.out.println(goods);
        Integer[] ids = new Integer[goods.length];
        for(int i = 0; i < ids.length; i++){
            ids[i] = Integer.parseInt(goods[i]);
        }
        List<Food> foods = foodMapper.getByIds(ids);
        return new ShopWhole(shopSimple.getId(), shopSimple.getShopName(), shopSimple.getShopNumber()
                , shopSimple.getAreaId(), shopSimple.getAreaName(), foods);
    }

    @Override
    public Double calHistoryIncome(Integer id) {
        return shopMapper.calHistoryIncome(id);
    }

    @Override
    public void calHistoryIncomeByProcedure(Map<String, Object> map){
//        map.put("money", -1);
        Double aDouble = shopMapper.calHistoryIncomeByProcedure(map);
        System.out.println(map.get("money"));
        System.out.println(aDouble+"====");
    }

    @Override
    public boolean addOneFood(Food food, Integer id) {
        ShopSimple simple = shopMapper.getById(id);
        if(simple == null)
            return false;
        simple.setGoods(simple.getGoods() + "|" + food.getId());
        String goods = simple.getGoods();
        return shopMapper.addOneFood(new FoodUpdate(id, goods));
    }

    @Override
    public List<ShopWhole> getShopsByFoodName(String foodName) {
        Food food = foodMapper.getByName(foodName);
        List<ShopSimple> simples = shopMapper.getShopsByFoodId(food.getId() + "");
        List<ShopWhole> wholes = new ArrayList<>();
        for(ShopSimple simple : simples){
            ShopWhole whole = convertsTo(simple);
            List<Food> foods = whole.getGoods();
            for(Food f : foods){
                if(f.getId() == food.getId()){
                    wholes.add(whole);
                    break;
                }
            }
        }
        return wholes;
    }
}
