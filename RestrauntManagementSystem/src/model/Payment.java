package model;

import enums.PaymentMethod;

public class Payment {

    private final double amount;
    private final PaymentMethod method;
    // processingFees

    //user
    public Payment(double amount,  PaymentMethod method)
    {
        this.amount = amount;
        this.method = method;
    }

//    public Payment(double amount,  PaymentMethod method, double processingFees)
//    {
//        this.amount = amount;
//        this.method = method;
    // this.processingFees = processingFees;
//    }

    // Payment -> paymentByUser
    // Payment -> paymentByRestraunt

    public double getPayment() {

        if(this.method.equals(PaymentMethod.CREDIT_CARD)) {
            // 1% extra on food bill through credit card payment
            return this.amount + (this.amount * 0.01) ;
        }
        else if(this.method.equals(PaymentMethod.CASH)) {
            // 5% extra on food bill on cash payment
            return this.amount + (this.amount * 0.05);
        }
        else if(this.method.equals(PaymentMethod.ONLINE_PAYMENT)) {
            return this.amount;
        }

        return 0;
    }

}
