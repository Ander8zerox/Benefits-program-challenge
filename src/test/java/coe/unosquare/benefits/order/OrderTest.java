/*
 *  OrderTest
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.business.exception.MethodPaymentNotFound;
import coe.unosquare.benefits.business.model.payment.PaymentTypeEnum;
import coe.unosquare.benefits.business.model.product.Product;
import coe.unosquare.benefits.business.util.Constants;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static coe.unosquare.benefits.util.PayOrderSimulator.payOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {
    @Test
    void orderWithVisaMoreThan10ProductsDiscountTest() throws MethodPaymentNotFound {
        Map<Product, Integer> products = ProductGenerator.generateProducts(15);
        assertEquals(Constants.FIFTEEN_PERCENT, payOrder(products, PaymentTypeEnum.VISA.getValue()));
    }

    @Test
    void orderWithVisa9ProductsDiscountTest() throws MethodPaymentNotFound {
        Map<Product, Integer> products = ProductGenerator.generateProducts(9);
        assertEquals(Constants.TEN_PERCENT, payOrder(products, PaymentTypeEnum.VISA.getValue()));
    }

    @Test
    void orderWithVisa6ProductsDiscountTest() throws MethodPaymentNotFound {
        Map<Product, Integer> products = ProductGenerator.generateProducts(6);
        assertEquals(Constants.FIVE_PERCENT, payOrder(products, PaymentTypeEnum.VISA.getValue()));
    }

    @Test
    void orderWithMastercardMoreThan100Total() throws MethodPaymentNotFound {
        Map<Product, Integer> products = ProductGenerator.generateProducts(108);
        assertEquals(Constants.SEVENTEEN_PERCENT, payOrder(products, PaymentTypeEnum.MASTERCARD.getValue()));
    }

    @Test
    void orderWithMastercardMoreThan75Total() throws MethodPaymentNotFound {
        Map<Product, Integer> products = ProductGenerator.generateProducts(76);
        assertEquals(Constants.TWELVE_PERCENT, payOrder(products, PaymentTypeEnum.MASTERCARD.getValue()));
    }

    @Test
    void orderWithMastercardLessThan75Total() throws MethodPaymentNotFound {
        Map<Product, Integer> products = ProductGenerator.generateProducts(14);
        assertEquals(Constants.EIGHT_PERCENT, payOrder(products, PaymentTypeEnum.MASTERCARD.getValue()));
    }

    @Test
    void shouldThrowMethodPaymentNotFound() throws MethodPaymentNotFound {
        Map<Product, Integer> products = ProductGenerator.generateProducts(108);
        assertThrows(MethodPaymentNotFound.class,() -> payOrder(products, "PSE PAYMENT"));
    }
}
