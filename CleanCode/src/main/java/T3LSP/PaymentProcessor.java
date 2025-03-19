package T3LSP;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {
        if (paymentStrategy.validatePaymentDetails()) {
            try {
                paymentStrategy.processPayment(amount);
            } catch (PaymentProcessingException e) {
                // Handle payment processing exception
                System.out.println("Payment failed: " + e.getMessage());
            }
        }
    }

}
