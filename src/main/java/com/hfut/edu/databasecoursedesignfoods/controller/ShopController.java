package com.hfut.edu.databasecoursedesignfoods.controller;

import com.hfut.edu.databasecoursedesignfoods.domain.Food;
import com.hfut.edu.databasecoursedesignfoods.domain.Income;
import com.hfut.edu.databasecoursedesignfoods.domain.ShopSimple;
import com.hfut.edu.databasecoursedesignfoods.domain.ShopWhole;
import com.hfut.edu.databasecoursedesignfoods.service.FoodService;
import com.hfut.edu.databasecoursedesignfoods.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/shop")
@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;

    @Autowired
    private FoodService foodService;

    @ResponseBody
    @RequestMapping(value = "/shops", method = RequestMethod.GET)
    public List<ShopWhole> getShops(){
        return shopService.getShops();
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public String getShopById(@PathVariable("id") Integer id, ModelMap modelMap){
        ShopWhole whole = shopService.getById(id);
        System.out.println(whole);
        modelMap.addAttribute("shop", whole);
        if(modelMap.containsAttribute("shops"))
            modelMap.remove("shops");
        return "admin/index";
    }

    @RequestMapping(value = "/getByAreaId/{id}", method = RequestMethod.GET)
    public String getShopByAreaId(@PathVariable("id") Integer id, ModelMap modelMap){
        List<ShopWhole> wholes = shopService.getByAreaId(id);
        modelMap.addAttribute("shops", wholes);
        if(modelMap.containsAttribute("shop"))
            modelMap.remove("shop");
        return "admin/index";
    }

    @RequestMapping(value = "/getFoodsByShop/{id}", method = RequestMethod.GET)
    public String getFoodsByShop(@PathVariable("id") Integer id, ModelMap modelMap){
        ShopWhole whole = shopService.getById(id);
        modelMap.addAttribute("foods", whole.getGoods());
        modelMap.addAttribute("thisShop", whole.getId());
        modelMap.addAttribute("thisShopName", whole.getShopName());
        return "admin/order";
    }

    @RequestMapping(value = "/toShopInfoPage/{id}", method = RequestMethod.GET)
    public String toShopInfoPage(@PathVariable("id") Integer id, ModelMap map){
        ShopWhole whole = shopService.getById(id);
        map.addAttribute("shopInfo", whole);
        return "admin/shopInfo";
    }

    @RequestMapping(value = "/updateShopInfo", method = RequestMethod.POST)
    public String updateShopInfo(ShopSimple simple, ModelMap map){
//        System.out.println(simple);
        shopService.updateShopInfo(simple);
        ShopWhole whole = shopService.getById(simple.getId());
        map.addAttribute("shop", whole);
        return "admin/index";
    }

    @ResponseBody
    @RequestMapping(value = "/calHistoryIncome")
    public String calHistoryIncome(@RequestBody List<String> shopId){
        if(shopId != null && shopId.size() > 0){
            Double income = shopService.calHistoryIncome(Integer.parseInt(shopId.get(0)));
            return String.valueOf(income);
        }
        return "null";
    }

    @ResponseBody
    @RequestMapping(value = "/procedure")
    public String calHistoryIncomeByProcedure(@RequestBody List<String> shopId){
        if(shopId != null && shopId.size() > 0){
            Map<String, Object> map = new HashMap<>();
            map.put("id", Integer.parseInt(shopId.get(0)));
            shopService.calHistoryIncomeByProcedure(map);
            return map.get("money").toString();
        }
        return "null";
    }

    @RequestMapping(value = "/toAddOneFoodPage/{id}", method = RequestMethod.GET)
    public String toAddOneFoodPage(@PathVariable("id") Integer id, ModelMap map, HttpSession session){
        map.addAttribute("shopId", id);
        session.setAttribute("shopId", id);
        return "admin/addFood";
    }

    /**
     * 添加一个food，就是向Shop维护的产品列表里加入这个food的id，别的没有其它了
     * @param food
     * @param map
     * @param session
     * @return
     */
    @RequestMapping(value = "/addOneFood", method = RequestMethod.POST)
    public String addOneFood(Food food, ModelMap map, HttpSession session){
        System.out.println("==============\n" + food + "\n===============");
        Integer shopId = (Integer) session.getAttribute("shopId");
        map.addAttribute("thisShop", shopId);

        Food food1 = foodService.getByName(food.getFoodName());
        boolean b = shopService.addOneFood(food1, shopId);
        ShopWhole whole = shopService.getById(shopId);
        map.addAttribute("foods", whole.getGoods());
        map.addAttribute("thisShopName", whole.getShopName());
        if(b){
            return "admin/order";
        }else {
            return "admin/index";
        }
    }

    @RequestMapping(value = "/getShopsByFoodName", method = RequestMethod.POST)
    public String getShopsByFoodName(Food food, ModelMap map){
        List<ShopWhole> wholes = shopService.getShopsByFoodName(food.getFoodName());
        map.addAttribute("shops", wholes);
        return "admin/index";
    }
}





















