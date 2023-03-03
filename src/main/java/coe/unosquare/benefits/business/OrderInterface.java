package coe.unosquare.benefits.business;

import coe.unosquare.benefits.business.model.payment.PaymentTypeEnum;
import coe.unosquare.benefits.business.model.product.Product;

import java.util.Map;

/**
 * Interface that defines the contract to process orders
 */
public interface OrderInterface {

    /**
     * Obtain the method payment type related to this implementation
     * @return payment method
     */
    PaymentTypeEnum getPaymentType();
    /**
     * Process order
     * @param products
     * @return discount offered for this kind of payment method
     */
    Double processOrder(Map<Product, Integer> products);
}
