import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VisitTest {

    @Test
    void testFileExists() {
        String fileName = "visits.txt";
        Path path = Path.of("src/" + fileName);
        assertTrue(Files.exists(path));
    }

    @Test
    void testCorrectLogFormat() {
        LocalDate date = LocalDate.now();
        assertEquals("Anna Andersson (SSN 2024-10-20) visited at " + date.toString(), Visit.getMessage("Anna Andersson", "2024-10-20"));
    }
}