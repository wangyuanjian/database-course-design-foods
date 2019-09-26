package com.hfut.edu.databasecoursedesignfoods.service;

import com.hfut.edu.databasecoursedesignfoods.domain.Message;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {

    public boolean insertMessage(Message message);
}
