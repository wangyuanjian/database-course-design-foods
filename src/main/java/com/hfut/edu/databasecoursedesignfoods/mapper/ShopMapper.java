package com.hfut.edu.databasecoursedesignfoods.mapper;

import com.hfut.edu.databasecoursedesignfoods.domain.Food;
import com.hfut.edu.databasecoursedesignfoods.domain.FoodUpdate;
import com.hfut.edu.databasecoursedesignfoods.domain.Income;
import com.hfut.edu.databasecoursedesignfoods.domain.ShopSimple;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopMapper {

    public ShopSimple getById(Integer id);

    public List<ShopSimple> getShops();

    public List<ShopSimple> getByAreaId(Integer id);

    /**
     * 根据商店找到
     * @param id
     * @return
     */
    public String getFoods(Integer id);

    /**
     * 修改商店信息，只允许修改手机号，我太残忍了
     * @param simple
     * @return
     */
    public boolean updateShopInfo(ShopSimple simple);

    /**
     * 计算商店历史收益
     * @param id
     * @return
     */
    public Double calHistoryIncome(Integer id);

    /**
     * 计算商店的历史收益,
     * 输入参数是商店id, 输出参数是商店历史收益
     * @param
     * @return
     */
    public Double calHistoryIncomeByProcedure(Map<String, Object> map);

    /**
     * 添加Food信息,就是向Shop维护的产品列表里加入这个food的id，别的没有其它了
     * @param update
     * @return
     */
    public boolean addOneFood(FoodUpdate update);

    public List<ShopSimple> getShopsByFoodId(String id);


}
