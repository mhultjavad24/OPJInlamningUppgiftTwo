import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PaymentParser {
    public static List<Payment> parsePayments(Path path) throws IOException {
        List<Payment> payments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Invalid payment data");
                }
                String socialSecurityNumber = parts[0].trim();
                String fullName = parts[1].trim();
                String date = reader.readLine().trim();
                Payment p = new Payment(socialSecurityNumber, fullName, date);
                payments.add(p);
            }
        } catch (IOException e) {
            throw new IOException("Invalid payment file");
        }
        return payments;
    }

}
