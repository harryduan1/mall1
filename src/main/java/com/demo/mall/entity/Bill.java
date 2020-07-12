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
 * @create 2020-07-11 18:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bill")
public class Bill {
    @TableId(type = IdType.AUTO)
    private int id;
    @TableField(value = "uid")
    private int uid;
    //状态,0为申请，1为成功
    @TableField(value = "status")
    private int status;
    //申请时间
    @TableField(value = "date")
    private Date date;


}
