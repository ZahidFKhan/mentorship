package T3LSP;

public class CreditCardPayment implements PaymentStrategy {
    private boolean validated = false;

    public boolean validatePaymentDetails() {
        if (!validated) {
            // Validate credit card details
            validated = true; // Assuming validation is successful
        }
        return validated;
    }

    public void processPayment(double amount) throws PaymentProcessingException {
        // Process credit card payment
    }
}