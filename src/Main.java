import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public Main() {
        try {
            Path p = Paths.get("src/payments.txt");
            List<Payment> payments = PaymentParser.parsePayments(p);
            String id = JOptionPane.showInputDialog(null, "Enter SSN or name:");
            if (id == null) {
                System.exit(0);
            }
            Payment payment = PaymentMatcher.find(id, payments);
            if (payment == null) {
                JOptionPane.showMessageDialog(null, "No payment history found for: " + id);
            } else {
                if (payment.isOlderThanXYears(1)) {
                    JOptionPane.showMessageDialog(null,  payment.getFullName() + " " + payment.getSocialSecurityNumber() + " is a previous member. New payment is required to renew membership");
                } else {
                    JOptionPane.showMessageDialog(null,  payment.getFullName() + " " + payment.getSocialSecurityNumber() + " is an active member with last payment at " + payment.getLastPaymentDate());
                    Visit.logVisit(payment.getFullName(), payment.getSocialSecurityNumber());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}