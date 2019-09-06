package com.lingyun.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @类名: PageController
 * @描述:
 * @作者: 郭廷俊
 * @时间: 2019-09-04 09:50
 **/
@Controller("page")
public class PageController {

    @RequestMapping("toZhu")
    public String toZhu(){
        return "jsp/booklist";
    }
}
