package T3LSP;


public class PayPalPayment implements PaymentStrategy {
    private boolean validated = false;

    public boolean validatePaymentDetails() {
        if (!validated) {
            // Validate PayPal account
            validated = true; // Assuming validation is successful
        }
        return validated;
    }

    public void processPayment(double amount) throws PaymentProcessingException {
        // Log in to PayPal and process payment
        if (!isBankAccountLinked()) {
            throw new PaymentProcessingException("PayPal account is not linked to a bank account");
        }
        // Process payment
    }

    public boolean isBankAccountLinked() {
        // Check if PayPal account is linked to a bank account
        return true; // Assuming it is linked for this example
    }
}
