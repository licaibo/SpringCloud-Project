package com.licaibo.provider.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 订单表
 * @author licaibo
 * @date 2020-04-05
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Table(name = "t_order")
public class Order {

    @Id
    private String orderId;

    private String name;

    private Date creatAt;

}
