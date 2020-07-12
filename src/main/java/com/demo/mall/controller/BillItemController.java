package com.demo.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.mall.entity.BillItem;
import com.demo.mall.entity.Goods;
import com.demo.mall.service.BillItemService;
import com.demo.mall.util.MallUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2020-07-12 9:04
 */
@RestController
@RequestMapping("/cart")
public class BillItemController {
    @Autowired
    private BillItemService billItemService;

    @PostMapping("/add")
    public String add(@RequestBody BillItem item) {
        billItemService.add(item);
        return MallUtil.getJSONString(0,"成功添加了一条订单项");
    }

    @GetMapping("/remove")
    public String remove(int goodsId) {
        billItemService.remove(goodsId);
        return MallUtil.getJSONString(0,"删除了一条订单项");
    }

    @PostMapping("/edit")
    public String edit(@RequestBody BillItem item) {
        billItemService.edit(item);
        return MallUtil.getJSONString(0,"更改了一条订单项");
    }

    @GetMapping("/list")
    public String list() {
        return billItemService.list();
    }

    @GetMapping("/listOne")
    public String list(int goodsId) {
        return billItemService.listOne(goodsId);
    }

    @GetMapping("/settle")
    public String settle() {
        billItemService.settle();
        return MallUtil.getJSONString(0,"提交申请成功");
    }
}
