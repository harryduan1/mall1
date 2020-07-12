package com.demo.mall.controller;

import com.demo.mall.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2020-07-12 16:00
 */
@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping("/list")
    public String list() {
        return billService.list();
    }

}
