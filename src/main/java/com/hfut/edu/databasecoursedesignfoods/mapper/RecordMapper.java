package com.hfut.edu.databasecoursedesignfoods.mapper;

import com.hfut.edu.databasecoursedesignfoods.domain.RecordSimple;
import com.sun.prism.impl.Disposer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {

    public List<RecordSimple> getByCustomerId(Integer id);

    public List<RecordSimple> getByCustomerName(String name);

    public List<RecordSimple> getByShopId(Integer id);

    /**
     * 插入一条销售数据
     * @param simple
     * @return
     */
    public boolean insertOneRecord(RecordSimple simple);

    /**
     * 根据id 查询 record
     * @param id
     * @return
     */
    public RecordSimple getById(Integer id);
}
