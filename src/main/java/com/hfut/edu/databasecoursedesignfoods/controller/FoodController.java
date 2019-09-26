package com.hfut.edu.databasecoursedesignfoods.controller;

import com.hfut.edu.databasecoursedesignfoods.domain.Food;
import com.hfut.edu.databasecoursedesignfoods.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @ResponseBody
    @RequestMapping(value = "/getId/{id}")
    public Food getFoodById(@PathVariable("id") Integer id){
        return foodService.getById(id);
    }

    /**
     * 下面这个方法不适合直接从web调用， 因为URL没法写汉字
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getName/{name}")
    public Food getFoodByName(@PathVariable("name") String name){
        return foodService.getByName(name);
    }

    @ResponseBody
    @RequestMapping(value = "/getByArray")
    public List<Food> getByArray(){
        Integer[] array = new Integer[]{1, 2, 3, 4};
        return foodService.getByIds(array);
    }

    @RequestMapping(value = "/toFoodInfoPage/{id}")
    public String toFoodInfoPage(@PathVariable("id") Integer id, ModelMap map){
        Food food = foodService.getById(id);
        map.addAttribute("food", food);
        return "admin/foodInfo";
    }

    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public String updateById(Food food){
        foodService.updateById(food);
//        System.out.println(food);
        return "admin/index";
    }

    @ResponseBody
    @RequestMapping(value = "/getAllFoodNames", method = RequestMethod.GET)
    public List<String> getAllFoodNames(){
        return foodService.getAllFoodNames();
    }
}



















