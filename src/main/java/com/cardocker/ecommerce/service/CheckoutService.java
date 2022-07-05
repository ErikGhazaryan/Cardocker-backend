package com.cardocker.ecommerce.service;

import com.cardocker.ecommerce.dto.Purchase;
import com.cardocker.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);


}
