package com.hfut.edu.databasecoursedesignfoods.mapper;

import com.hfut.edu.databasecoursedesignfoods.domain.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {
    public boolean insertMessage(Message message);
}
