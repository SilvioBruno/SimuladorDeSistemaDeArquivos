 package Sistema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Journal {
    private static final String JOURNAL_FILE = "Journaling/journal.txt";

    public static void log(String operation, String path){
        try (FileWriter fw = new FileWriter(JOURNAL_FILE, true);
            PrintWriter pw = new PrintWriter(fw)){
                String logEntry = String.format("[%s] OPERATION: %s, PATH: %s", java.time.LocalDateTime.now(), operation, path);
                pw.println(logEntry);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
}