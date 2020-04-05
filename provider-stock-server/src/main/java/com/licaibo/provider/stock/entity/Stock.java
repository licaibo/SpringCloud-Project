package com.licaibo.provider.stock.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 库存表
 * @author licaibo
 * @date 2020-04-05
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Table(name = "t_stock")
public class Stock {

    @Id
    private String id;

    private String name;

    private Integer count;

    private Date creatAt;

    private Date updateAt;

}
