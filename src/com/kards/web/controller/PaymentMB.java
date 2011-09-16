/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kards.web.controller;

import com.kards.util.DoDirectPayment;
import com.kards.util.PayPalFunctions;
import com.paypal.sdk.util.TestConnection;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author aungta
 */
public class PaymentMB implements Serializable
{

    private String paymentMethod = "";
    private double amount = 0.0;

    /** Creates a new instance of PaymentMB */
    public PaymentMB()
    {
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public String makePayment()
    {
        DoDirectPayment ddp = new DoDirectPayment();
        String ack = ddp.DoDirectPaymentCode("Authorization",
                                             "100.00",
                                             "Visa",
                                             "4405435173537581",
                                             "92016",
                                             "",
                                             "Aung",
                                             "Thaw Aye",
                                             "",
                                             "Singapore",
                                             "Singapore",
                                             "94121",
                                             "US");
        System.out.println(ack);
//        PayPalFunctions ppf = new PayPalFunctions();
//        ppf.DirectPayment("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
        return "";
    }
}
