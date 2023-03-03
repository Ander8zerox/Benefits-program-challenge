package coe.unosquare.benefits.business.model.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Enum Class for Payment types
 */
@AllArgsConstructor
public enum PaymentTypeEnum {

    VISA ("VISA"),
    MASTERCARD("MASTERCARD");

    @Getter
    private String value;
}
