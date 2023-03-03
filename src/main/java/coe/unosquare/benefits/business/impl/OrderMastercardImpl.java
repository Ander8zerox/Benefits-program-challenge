package coe.unosquare.benefits.business.impl;

import coe.unosquare.benefits.business.OrderInterface;
import coe.unosquare.benefits.business.model.payment.PaymentTypeEnum;
import coe.unosquare.benefits.business.model.product.Product;
import coe.unosquare.benefits.business.util.Constants;

import java.util.Map;

/**
 * Implementation of the MasterCard payment method
 */
public class OrderMastercardImpl implements OrderInterface {


    @Override
    public PaymentTypeEnum getPaymentType() {
        return PaymentTypeEnum.MASTERCARD;
    }

    @Override
    public Double processOrder(Map<Product, Integer> products) {

        double discount;

        if (products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getProductPrice() * product.getValue())
                .sum() >= Constants.TOTAL_AMOUNT_100) {
            discount = Constants.SEVENTEEN_PERCENT;
        } else if (products.entrySet().stream()
                .mapToDouble(product -> product.getKey().getProductPrice() * product.getValue())
                .sum() >= Constants.TOTAL_AMOUNT_75) {
            discount = Constants.TWELVE_PERCENT;
        } else {
            discount = Constants.EIGHT_PERCENT;
        }

        return discount;
    }
}
