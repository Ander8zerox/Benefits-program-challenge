package coe.unosquare.benefits.business.impl;

import coe.unosquare.benefits.business.OrderInterface;
import coe.unosquare.benefits.business.model.payment.PaymentTypeEnum;
import coe.unosquare.benefits.business.model.product.Product;
import coe.unosquare.benefits.business.util.Constants;

import java.util.Map;

/**
 * Implementation of the Visa payment method
 */
public class OrderVisaImpl implements OrderInterface {

    @Override
    public PaymentTypeEnum getPaymentType() {
        return PaymentTypeEnum.VISA;
    }

    @Override
    public Double processOrder(Map<Product, Integer> products) {

        double discount;

        if (products.values()
                .stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity) >= Constants.TEN_PRODUCTS) {
            discount = Constants.FIFTEEN_PERCENT;
        } else if (products.values()
                .stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity) >= Constants.SEVEN_PRODUCTS) {
            discount = Constants.TEN_PERCENT;
        } else {
            discount = Constants.FIVE_PERCENT;
        }

        return discount;
    }
}
