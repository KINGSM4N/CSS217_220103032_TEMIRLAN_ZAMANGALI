import java.math.BigDecimal;

public class PaymentGatewayAdapter implements IPaymentGateway {

    private final LegacyBillingSystem legacyBillingSystem;

    public PaymentGatewayAdapter(LegacyBillingSystem legacyBillingSystem) {
        this.legacyBillingSystem = legacyBillingSystem;
    }

    @Override
    public void processPayment(int customerId, BigDecimal amountInDollars) {
        if (amountInDollars == null || amountInDollars.signum() < 0) {
            throw new IllegalArgumentException("amountInDollars must not be null or negative: " + amountInDollars);
        }

        long amountInCents = amountInDollars.multiply(BigDecimal.valueOf(100)).longValueExact();

        legacyBillingSystem.chargeCustomerInCents(customerId, amountInCents);
    }
}