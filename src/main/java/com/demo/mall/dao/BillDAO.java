package com.demo.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.mall.entity.Bill;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shkstart
 * @create 2020-07-12 8:38
 */
@Mapper
public interface BillDAO extends BaseMapper<Bill> {
}
