package com.demo.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shkstart
 * @create 2020-07-11 18:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("suggestion")
public class Suggestion {
    @TableId(type = IdType.AUTO)
    private int id;
    @TableField(value = "content")
    private String content;
    //用户类型
    @TableField(value = "type")
    private int type;
    //所属订单
    @TableField(value = "bid")
    private int bid;


}
