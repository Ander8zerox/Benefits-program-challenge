package coe.unosquare.benefits.business.util;

import coe.unosquare.benefits.business.model.product.Product;

import java.util.Map;

/**
 * Utility class for transversal methods
 */
public class Utilities {

    /**
     * Print.
     */
    public static void print(Map<Product, Integer> products) {
        products.forEach((product, quantity) ->
                System.out.println("Product:{" + product.getProductName() + ","
                        + product.getProductPrice() + ","
                        + product.getProductType()
                        + "},Quantity:" + quantity
                        + ",Total:" + product.getProductPrice() * quantity));
    }
}
