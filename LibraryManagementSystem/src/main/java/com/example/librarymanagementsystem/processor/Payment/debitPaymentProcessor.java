package com.example.librarymanagementsystem.processor.Payment;

import com.example.librarymanagementsystem.Enums.payments;
import com.example.librarymanagementsystem.processor.Interface.PaymentProcessor;

public class debitPaymentProcessor implements PaymentProcessor {

    @Override
    public String getType() {
        return String.valueOf(payments.DEBIT);
    }
}
