package com.demo.mall.service;

import com.alibaba.fastjson.JSONObject;
import com.demo.mall.dao.BillItemDAO;
import com.demo.mall.dao.GoodsDAO;
import com.demo.mall.entity.BillItem;
import com.demo.mall.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-07-12 8:43
 */
@Service
public class BillItemService {
    @Autowired
    private HttpSession session;

    @Autowired
    private BillService billService;

    @Autowired
    private BillItemDAO billItemDAO;

    @Autowired
    private GoodService goodService;

    private HashMap<Integer, BillItem> myCart;

    public boolean add(BillItem item) {
        getCart();
        BillItem oldItem = myCart.get(item.getGid());
        if(oldItem==null){
            myCart.put(item.getGid(), item);
        }else {
            oldItem.setNumber(oldItem.getNumber()+item.getNumber());
        }

        return true;
    }

    public boolean remove(int goodsId) {
        getCart();
        myCart.remove(goodsId);
        return true;
    }
    //编辑一条订单里的数据
    public boolean edit(BillItem item) {
        getCart();
        myCart.put(item.getGid(), item);
        return true;
    }
    //申请人看到的“购物车”
    public String list() {
        getCart();
        List<Map<String, Object>> items = new ArrayList<>();
        for(int key:myCart.keySet()){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("item",myCart.get(key));
            hashMap.put("goods",goodService.selectById(myCart.get(key).getGid()));
            items.add(hashMap);
        }

        return JSONObject.toJSONString(items);
    }

    public String listOne(int goodsId) {
        getCart();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("item",myCart.get(goodsId));
        hashMap.put("goods",goodService.selectById(myCart.get(goodsId).getGid()));
        return JSONObject.toJSONString(hashMap);
    }

    public int getOwnerId() {
        return 1; //此处用户ID为1
    }

    public boolean settle() {
        billService.settleCart(getOwnerId());
        return true;
    }
    public int insert(BillItem billItem){
        return  billItemDAO.insert(billItem);
    }

    public List<BillItem> selectByBid(int bid){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("bid",bid);
       return billItemDAO.selectByMap(hashMap);
    }

    public HashMap<Integer, BillItem> getCart() {
        myCart = (HashMap) session.getAttribute("myCart");
        if (myCart == null) {
            myCart = new HashMap<Integer, BillItem>();
            session.setAttribute("myCart", myCart);
        }
        return myCart;
    }
}
