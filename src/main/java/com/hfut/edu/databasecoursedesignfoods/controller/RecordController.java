package com.hfut.edu.databasecoursedesignfoods.controller;

import com.hfut.edu.databasecoursedesignfoods.domain.*;
import com.hfut.edu.databasecoursedesignfoods.service.MessageService;
import com.hfut.edu.databasecoursedesignfoods.service.RecordService;
import com.hfut.edu.databasecoursedesignfoods.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/getByCustomerId/{id}")
    public List<RecordWhole> getByCustomerId(@PathVariable("id") Integer id){
        return recordService.getByCustomerId(id);
    }

    @RequestMapping(value = "/getByCustomerName/{name}")
    public String getByCustomerName(@PathVariable("name") String name, ModelMap map){
//        return recordService.getByCustomerId(id);
        List<RecordWhole> wholes = recordService.getByCustomerName(name);
        map.addAttribute("records", wholes);
        return "admin/myOrder";
    }

    @RequestMapping(value = "/getByShopId/{id}")
    public String getByShopId(@PathVariable("id") Integer id, ModelMap modelMap){
        List<RecordWhole> wholes = recordService.getByShopId(id);
        modelMap.addAttribute("records", wholes);
        ShopWhole whole = shopService.getById(id);
        modelMap.addAttribute("thisShop", whole.getId());
        modelMap.addAttribute("thisShopName", whole.getShopName());
        return "admin/income";
    }

    /**
     * @param ids 两部分组成，ids.get(0) 是shopId, 其他的是Food 的id
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/commit")
    public String commit(@RequestBody List<String> ids, HttpSession session) throws IOException {
//        System.out.println(ids);
//        response.getWriter().write("success");
        RecordSimple simple = new RecordSimple();

        // 获取当前用户id
        Customer user = (Customer)session.getAttribute("user");
        simple.setCustomerId(user.getId());
        simple.setShopId(Integer.parseInt(ids.get(0)));
        System.out.println(recordService.insertOneRecord(simple, ids));
        return "success";
    }

    /**
     * @param id 这个参数id 是record 的id
     * @return
     */
    @RequestMapping(value = "/toLeaveMessagePage/{id}", method = RequestMethod.GET)
    public String toLeaveMessagePage(@PathVariable("id") Integer id, ModelMap map){
        RecordWhole whole = recordService.getById(id);
        map.addAttribute("record", whole);
        return "admin/leaveMessage";
    }

    @RequestMapping(value = "/commitMessage", method = RequestMethod.POST)
    public String commitMessage(Message message, ModelMap map){
        System.out.println(message);
        boolean b = messageService.insertMessage(message);
        if(b){
            List<RecordWhole> wholes = recordService.getByCustomerId(message.getCustomerId());
            map.put("records", wholes);
            return "admin/myOrder";
        }else {
            map.put("errorMsg", "评论失败 :(");
            return "admin/error";
        }
    }
}
