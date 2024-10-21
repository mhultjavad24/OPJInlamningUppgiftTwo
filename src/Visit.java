import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Visit {
    public static void logVisit(String id, String id2) {
        String message = getMessage(id, id2);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/visits.txt", true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMessage(String id, String id2) {
        return id + " (SSN " + id2 + ") visited at " + LocalDate.now().toString();
    }
}
