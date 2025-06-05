import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Classe responsável por interpretar comandos de um arquivo texto e executar no sistema de arquivos simulado
public class Shell {
    private FileSystemSimulator fs; // Instância do sistema de arquivos

    // Construtor: inicializa o simulador
    public Shell() {
        fs = new FileSystemSimulator();
    }

    // Interpreta e executa comandos a partir de um arquivo de texto
    public void interpret(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Lê cada linha do arquivo de comandos
            while ((line = reader.readLine()) != null) {
                System.out.println("Executando: " + line); // Mostra o comando sendo executado

                // Divide a linha em partes com base nos espaços
                String[] parts = line.split("]");
                String commandPart = parts[0].trim(); // Ex: [Criar Pasta
                String argumentPart = parts.length > 1 ? parts[1].trim() : ""; // Ex: nome da pasta/arquivo

                // Interpreta o comando principal
                if (commandPart.contains("Criar Pasta")) {
                    fs.createFolder(argumentPart); // Cria uma pasta
                } else if (commandPart.contains("Criar Arquivo")) {
                    fs.createFile(argumentPart, ""); // Cria um arquivo com conteúdo vazio
                } else if (commandPart.contains("Deletar Pasta")) {
                    fs.deleteFolder(argumentPart); // Remove pasta
                } else if (commandPart.contains("Deletar Arquivo")) {
                    fs.deleteFile(argumentPart); // Remove arquivo
                } else if (commandPart.contains("Abrir Pasta")) {
                    fs.changeDirectory(argumentPart); // Entra em um subdiretório
                } else if (commandPart.contains("Voltar")) {
                    fs.resetToRoot(); // Volta para o diretório raiz
                } else if (commandPart.contains("Listar")) {
                    // Lista conteúdo atual
                    for (String item : fs.listCurrentDirectoryContents()) {
                        System.out.println(item);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    // Método principal que inicia o interpretador com o arquivo journal.txt
    public static void main(String[] args) {
        Shell shell = new Shell(); // Cria uma nova instância do shell
        shell.interpret("journal.txt"); // Executa os comandos no arquivo journal.txt
    }
}
