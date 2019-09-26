package com.hfut.edu.databasecoursedesignfoods.controller;

import com.hfut.edu.databasecoursedesignfoods.common.MyEncrypt;
import com.hfut.edu.databasecoursedesignfoods.domain.Customer;
import com.hfut.edu.databasecoursedesignfoods.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping(value = "/admin")
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login")
    public String login(){
        return "admin/login";
    }

    @RequestMapping(value = "/validate")
    public String validate(Customer customer, Model model, HttpSession session){
        Customer customer1 = customerService.getByName(customer.getCustomerName());
        // 实现账户的密码加密
        String fromWeb = MyEncrypt.md5(customer.getPassword()).substring(1, 16);
//        System.out.println("from web + " + fromWeb);
//        System.out.println(customer1);
        if(customer1 == null){
            model.addAttribute("errorMsg", "该用户不存在");
            return "admin/login";
        } else if(!fromWeb.equals(customer1.getPassword())){
            model.addAttribute("errorMsg", "密码错误");
            return "admin/login";
        } else {
            model.addAttribute("loginUser", customer.getCustomerName());
            session.setAttribute("loginUser", customer.getCustomerName());
            session.setAttribute("user", customer1);
            return "admin/index";
        }
    }

    @RequestMapping(value = "/logout/{name}")
    public String logout(@PathVariable("name") String name, HttpSession session){
        session.removeAttribute(name);
        return "admin/login";
    }

    @RequestMapping(value = "/toIndex")
    public String toIndex(){
        return "admin/index";
    }

    @RequestMapping(value = "/toRegisterPage", method = RequestMethod.GET)
    public String toRegisterPage(){
        return "admin/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Customer customer, ModelMap map, HttpSession session){

        Customer customer1 = customerService.getByName(customer.getCustomerName());
        if(customer1 != null){
            map.addAttribute("errorMsg", "该用户已存在");
            return "admin/register";
        }
        if(customerService.register(customer)){
            map.addAttribute("loginUser", customer.getCustomerName());
            session.setAttribute("loginUser", customer.getCustomerName());
            session.setAttribute("user", customer);
            return "admin/index";
        }
        else
            return "admin/register";
    }
}

















