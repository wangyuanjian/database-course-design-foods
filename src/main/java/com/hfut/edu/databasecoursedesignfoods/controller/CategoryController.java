package com.hfut.edu.databasecoursedesignfoods.controller;

import com.hfut.edu.databasecoursedesignfoods.domain.Category;
import com.hfut.edu.databasecoursedesignfoods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(value = "/category")
@Controller
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> list(){
        System.out.println("=================");
        return categoryService.list();
    }
}
