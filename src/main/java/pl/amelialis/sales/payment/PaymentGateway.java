package pl.amelialis.sales.payment;

public interface PaymentGateway {
    PaymentData register(RegisterPaymentRequest request);
}