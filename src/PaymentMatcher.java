import java.util.List;

public class PaymentMatcher {
    public static Payment find(String text, List<Payment> payments) {
        if (text.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid search text");
        }
        for (Payment payment : payments) {
            if (text.equalsIgnoreCase(payment.getSocialSecurityNumber())) {
                return payment;
            }
            if (text.equalsIgnoreCase(payment.getFullName())) {
                return payment;
            }
        }
        return null;
    }
}
