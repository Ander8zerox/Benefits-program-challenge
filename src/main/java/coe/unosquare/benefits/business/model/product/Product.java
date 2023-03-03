/*
 *  Product
 *  1.0
 *  11/8/22, 8:30 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.business.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Product.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {
    /** The Product name. **/
    private String productName;
    /** The Product price. **/
    private Double productPrice;
    /** The Product type defined by: 1 = Basic need, 2 =  Work tool, 3 = Luxury.  **/
    private Integer productType;

}
