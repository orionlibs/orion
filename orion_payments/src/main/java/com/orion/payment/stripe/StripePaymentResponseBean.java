package com.orion.payment.stripe;

import com.google.gson.annotations.SerializedName;

public class StripePaymentResponseBean
{
    @SerializedName("payment_intent")
    private String paymentIntent;
    @SerializedName("setup_intent")
    private String setupIntent;


    public StripePaymentResponseBean()
    {
    }


    public String getPaymentIntent()
    {
        return this.paymentIntent;
    }


    public void setPaymentIntent(String paymentIntent)
    {
        this.paymentIntent = paymentIntent;
    }


    public String getSetupIntent()
    {
        return this.setupIntent;
    }


    public void setSetupIntent(String setupIntent)
    {
        this.setupIntent = setupIntent;
    }
}