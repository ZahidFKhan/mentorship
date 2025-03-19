package T3LSP;

public interface PaymentStrategy {
	boolean validatePaymentDetails();
    void processPayment(double amount) throws PaymentProcessingException;
}
