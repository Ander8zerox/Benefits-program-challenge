/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.business.OrderInterface;
import coe.unosquare.benefits.business.exception.MethodPaymentNotFound;
import coe.unosquare.benefits.business.impl.OrderMastercardImpl;
import coe.unosquare.benefits.business.impl.OrderVisaImpl;
import coe.unosquare.benefits.business.model.payment.PaymentTypeEnum;
import coe.unosquare.benefits.business.model.product.Product;
import coe.unosquare.benefits.business.util.Constants;
import coe.unosquare.benefits.business.util.Utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Order.
 */
public class Order {
    /** Store the final list of products and quantity for each product. **/
    private final Map<Product, Integer> products;

    /**
     * Instantiates a new Order.
     *
     * @param productsMap the list of products added to the order
     */
    public Order(final Map<Product, Integer> productsMap) {
        products = productsMap;
    }

    /**
     * Pay double.
     *
     * @param paymentType the payment type
     * @return the double
     */
    public Double pay(final String paymentType) throws MethodPaymentNotFound {

        Double discount;

        Map<String, OrderInterface> orderMap = new HashMap<>();
        orderMap.put(PaymentTypeEnum.VISA.getValue(), new OrderVisaImpl());
        orderMap.put(PaymentTypeEnum.MASTERCARD.getValue(), new OrderMastercardImpl());

        if(!orderMap.containsKey(paymentType)){
            throw new MethodPaymentNotFound(Constants.INVALID_PAYMENT_METHOD + paymentType);
        }else{
            discount = orderMap.get(paymentType).processOrder(products);
        }

        return calculateTotalAmount(discount,products);
    }

    /**
     * calculate the amount to pay.
     * @param discount
     * @param products
     * @return the total amount of the purchase
     */
    private Double calculateTotalAmount(double discount, Map<Product, Integer> products){
        double subtotal = products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getProductPrice() * product.getValue())
                .sum();
        return subtotal - subtotal * discount;
    }
}
