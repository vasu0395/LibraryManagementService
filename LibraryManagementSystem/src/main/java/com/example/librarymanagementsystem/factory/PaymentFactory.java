package com.example.librarymanagementsystem.factory;

import com.example.librarymanagementsystem.processor.Interface.PaymentProcessor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PaymentFactory implements Serializable {
    private final Map<String, PaymentProcessor> paymentProcessorMap = new HashMap<>();

    public PaymentFactory(List<PaymentProcessor> paymentProcessors) {
        for (PaymentProcessor paymentProcessor : paymentProcessors)
            paymentProcessorMap.put(paymentProcessor.getType(), paymentProcessor);
    }

    public PaymentProcessor getPaymentProcessor(String type) throws Exception{
        PaymentProcessor paymentProcessor = paymentProcessorMap.get(type);
        if(Objects.nonNull(paymentProcessor))
            return paymentProcessor;

        throw new Exception("Payment type not supported!");
    }
}
