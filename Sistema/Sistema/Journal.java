package Sistema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Journal {
    private static final String JOURNAL_FILE = "Journaling/journal.txt";

    public static void log(String operation, String path) {
        try (FileWriter fw = new FileWriter(JOURNAL_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String log = String.format("[%s] %s -> %s", LocalDateTime.now(), operation, path);
            pw.println(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
