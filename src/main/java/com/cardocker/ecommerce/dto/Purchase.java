package com.cardocker.ecommerce.dto;


import com.cardocker.ecommerce.entity.Order;
import com.cardocker.ecommerce.entity.OrderItem;
import com.cardocker.ecommerce.entity.Address;
import com.cardocker.ecommerce.entity.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;


}
