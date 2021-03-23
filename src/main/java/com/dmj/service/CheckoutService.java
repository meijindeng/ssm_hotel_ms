package com.dmj.service;

import com.dmj.entity.Checkout;

public interface CheckoutService {
    /**
     * 添加退房记录
     * @param checkout
     * @return
     */
    int addCheckout(Checkout checkout);
}
