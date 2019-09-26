package com.hfut.edu.databasecoursedesignfoods.service.impl;

import com.hfut.edu.databasecoursedesignfoods.domain.Message;
import com.hfut.edu.databasecoursedesignfoods.mapper.MessageMapper;
import com.hfut.edu.databasecoursedesignfoods.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public boolean insertMessage(Message message) {
        Date date = new Date();
        DateFormat df2 = DateFormat.getDateTimeInstance();
        message.setTime(df2.format(date));

        // 客户已经评论
        message.setCustomerRead(1);
        return messageMapper.insertMessage(message);
    }
}
