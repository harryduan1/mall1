package com.demo.mall.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.mall.dao.SuggestionDAO;
import com.demo.mall.entity.Bill;
import com.demo.mall.entity.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-12 15:22
 */
@Service
public class SuggestionService {
    @Autowired
    SuggestionDAO suggestionDAO;
    @Autowired
    BillService billService;

    public int insert(Suggestion suggestion) {
        int result = suggestionDAO.insert(suggestion);
        int count = selectCountByBid(suggestion.getBid());
        if (count == 5) {
            Bill bill=billService.selectById(suggestion.getBid());
            bill.setStatus(1);
            billService.updateSatus(bill);
        }
        return result;
    }

    public int selectCountByBid(int bid) {
        QueryWrapper<Suggestion> queryWrapper = new QueryWrapper();
        queryWrapper.between("bid", bid, bid);
        return suggestionDAO.selectCount(queryWrapper);
    }
    public List<Suggestion> selectByBid(int bid){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("bid",bid);
       return suggestionDAO.selectByMap(hashMap);
    }
}
