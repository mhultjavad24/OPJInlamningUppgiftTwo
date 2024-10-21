import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    @Test
    void testPaymentInstance() {
        Payment payment = new Payment("7703021234", "Alhambra Aromes", "2023-10-19");
        assertEquals("7703021234", payment.getSocialSecurityNumber());
        assertEquals("Alhambra Aromes", payment.getFullName());
        assertEquals("2023-10-19", payment.getLastPaymentDate().toString());
    }

    @Test
    void testPaymentDateMethod() {
        Payment payment = new Payment("7703021234", "Alhambra Aromes", "2023-10-19");
        assertTrue(payment.isOlderThanXYears(1));
        assertFalse(payment.isOlderThanXYears(2));
        assertTrue(payment.isOlderThanXYears(0));
    }

}