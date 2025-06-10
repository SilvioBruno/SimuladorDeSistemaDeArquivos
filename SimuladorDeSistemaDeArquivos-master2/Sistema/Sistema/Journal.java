package Sistema;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Journal {
    private static final String path = "Journaling/journal.txt";

    public static void log(String operation, String description) {
        try {
            File dir = new File("Journaling");
            if (!dir.exists()) {
                dir.mkdir();
            }

            FileWriter fw = new FileWriter(path, true);
            PrintWriter pw = new PrintWriter(fw);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            pw.println("[" + formattedDateTime + "] [" + operation + "] " + description);
            pw.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no journal: " + e.getMessage());
        }
    }
}
