import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Payment {
    private String socialSecurityNumber;
    private String fullName;
    private LocalDate lastPaymentDate;

    public Payment(String socialSecurityNumber, String fullName, String lastPaymentDate) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.fullName = fullName;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.lastPaymentDate = LocalDate.parse(lastPaymentDate, dtf);
    }

    public boolean isOlderThanXYears(int years) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(lastPaymentDate, now);
        return period.getYears() >= years;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", lastPaymentDate=" + lastPaymentDate +
                '}';
    }
}
