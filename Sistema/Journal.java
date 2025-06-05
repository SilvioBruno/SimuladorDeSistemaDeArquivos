// Define o pacote onde essa classe está localizada
package Sistema;

// Importa classes necessárias para manipulação de arquivos e escrita
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Classe responsável por registrar operações em um arquivo de log (journal)
public class Journal {

    // Caminho do arquivo onde os logs serão salvos
    private static final String path = "Journaling/journal.txt";

    /**
     * Método para registrar uma operação no arquivo de journal
     * @param operation Tipo da operação (ex: "Criar Pasta", "Deletar Arquivo")
     * @param description Detalhes da operação (ex: nome da pasta ou arquivo)
     */
    public static void log(String operation, String description) {
        try {
            // Cria o diretório "Journaling" se ele ainda não existir
            File dir = new File("Journaling");
            if (!dir.exists()) {
                dir.mkdir(); // Cria o diretório
            }

            // Abre o arquivo journal.txt no modo de append (acrescentar no final)
            FileWriter fw = new FileWriter(path, true);

            // Facilita a escrita no arquivo
            PrintWriter pw = new PrintWriter(fw);

            // Escreve a linha de log no formato: [Operação] descrição
            pw.println("[" + operation + "] " + description);

            // Fecha o PrintWriter (e automaticamente o FileWriter)
            pw.close();

        } catch (IOException e) {
            // Em caso de erro (como falta de permissão ou disco cheio), exibe mensagem
            System.out.println("Erro ao escrever no journal: " + e.getMessage());
        }
    }
}
