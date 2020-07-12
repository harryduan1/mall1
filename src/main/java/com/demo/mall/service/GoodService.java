package com.demo.mall.service;

import com.demo.mall.dao.GoodsDAO;
import com.demo.mall.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2020-07-12 12:51
 */
@Service
public class GoodService {
    @Autowired
    private GoodsDAO goodsDAO;

    public Goods selectById(int id){
        Goods goods = goodsDAO.selectById(id);
        return goods;
    }
}
