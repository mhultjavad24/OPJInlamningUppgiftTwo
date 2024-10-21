import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentParserTest {

    @Test
    void testValidFile() throws IOException {
        Path tempFile = Files.createTempFile("payments", ".txt");
        String validData = "19911011,Marcus Andersson\n2024-01-01\n198505055678,Jane Smith\n2024-02-15";
        Files.writeString(tempFile, validData);
        List<Payment> payments = PaymentParser.parsePayments(tempFile);
        assertEquals(2, payments.size());
        assertEquals("Marcus Andersson", payments.get(0).getFullName());
        Files.delete(tempFile);
    }

    @Test
    void testInvalidFilePath() throws IOException {
        Path tempFile = Files.createTempFile("payments", ".txt");
        String validData = "19911011; Marcus Andersson\n2024-01-01\n198505055678,Jane Smith\n2024-02-15";
        Files.writeString(tempFile, validData);
        Files.delete(tempFile);
        assertThrows(IOException.class, () -> PaymentParser.parsePayments(tempFile));
    }

    @Test
    void testInvalidFile() throws IOException {
        Path tempFile = Files.createTempFile("payments", ".txt");
        String validData = "19911011; Marcus Andersson\n2024-01-01\n198505055678,Jane Smith\n2024-02-15";
        Files.writeString(tempFile, validData);
        assertThrows(IllegalArgumentException.class, () -> PaymentParser.parsePayments(tempFile));
        Files.delete(tempFile);
    }

    @Test
    void testEmptyFile() throws IOException {
        Path tempFile = Files.createTempFile("payments", ".txt");
        String validData = "";
        Files.writeString(tempFile, validData);
        List<Payment> payments = PaymentParser.parsePayments(tempFile);
        assertTrue(payments.isEmpty());
        Files.delete(tempFile);
    }
}