package com.demo.mall.controller;

import com.demo.mall.dao.SuggestionDAO;
import com.demo.mall.entity.BillItem;
import com.demo.mall.entity.Suggestion;
import com.demo.mall.service.SuggestionService;
import com.demo.mall.util.MallUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2020-07-12 15:21
 */
@RestController
@RequestMapping("/suggestion")
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    @PostMapping("/add")
    public String add(@RequestBody Suggestion suggestion) {
        suggestionService.insert(suggestion);
        return MallUtil.getJSONString(0,"成功添加了一条建议");
    }

}
