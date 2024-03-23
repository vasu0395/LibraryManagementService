package com.example.librarymanagementsystem.processor.Payment;

import com.example.librarymanagementsystem.Enums.payments;
import com.example.librarymanagementsystem.processor.Interface.PaymentProcessor;

public class creditPaymentProcessor implements PaymentProcessor {

    @Override
    public String getType() {
        return String.valueOf(payments.CREDIT);
    }
}