package coe.unosquare.benefits.business.exception;

/**
 * Custom exception to manage unknown payment methods
 */
public class MethodPaymentNotFound extends Exception{

    public MethodPaymentNotFound(String message){
        super(message);
    }
}
