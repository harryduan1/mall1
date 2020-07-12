package com.demo.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shkstart
 * @create 2020-07-11 18:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("billitem")
public class BillItem {
    @TableId(type = IdType.AUTO)
    private int id;
    //所属账单
    @TableField(value = "bid")
    private int bid;
    @TableField(value = "gid")
    private int gid;
    @TableField(value = "number")
    private int number;
    //需要时间
    @TableField(value = "day")
    private int day;
    //用途地点
    @TableField(value = "place")
    private String place;


}
