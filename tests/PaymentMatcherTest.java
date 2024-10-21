import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentMatcherTest {
    @Test
    void testFind() {
        Payment payment1 = new Payment("7703021234", "Alhambra Aromes", "2023-10-19");
        Payment payment2 = new Payment("7703021235", "Alhambra Second", "2023-10-19");
        Payment payment3 = new Payment("7703021236", "Alhambra Aromes", "2023-10-19");
        List<Payment> payments = List.of(payment1, payment2, payment3);
        assertEquals(payment1, PaymentMatcher.find("7703021234", payments));
        assertEquals(payment2, PaymentMatcher.find("Alhambra Second", payments));
        assertEquals(payment3, PaymentMatcher.find("7703021236", payments));
        assertNull(PaymentMatcher.find("7703021237", payments));
    }

    @Test
    void testEmptyText() {
        Payment payment1 = new Payment("7703021234", "Alhambra Aromes", "2023-10-19");
        List<Payment> payments = List.of(payment1);
        assertThrows(IllegalArgumentException.class, () -> PaymentMatcher.find(" ", payments));
    }
}
