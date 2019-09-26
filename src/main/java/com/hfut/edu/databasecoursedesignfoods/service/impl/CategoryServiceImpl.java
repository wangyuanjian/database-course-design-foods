package com.hfut.edu.databasecoursedesignfoods.service.impl;

import com.hfut.edu.databasecoursedesignfoods.domain.Category;
import com.hfut.edu.databasecoursedesignfoods.mapper.CategoryMapper;
import com.hfut.edu.databasecoursedesignfoods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.allCategories();
    }
}
