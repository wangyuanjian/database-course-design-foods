package com.hfut.edu.databasecoursedesignfoods.service;

import com.hfut.edu.databasecoursedesignfoods.domain.Category;
import com.hfut.edu.databasecoursedesignfoods.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    /**
     * 查询所有饮品分类列表
     * @return
     */
    public List<Category> list();
}
