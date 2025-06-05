import java.util.ArrayList;
import java.util.List;

// Representa um diretório no sistema de arquivos simulado
public class Directory {
    private String name; // Nome do diretório
    private List<Directory> subdirectories; // Lista de subdiretórios
    private List<File> files; // Lista de arquivos dentro deste diretório

    // Construtor: inicializa o diretório com nome e listas vazias
    public Directory(String name) {
        this.name = name;
        this.subdirectories = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    // Retorna o nome do diretório
    public String getName() {
        return name;
    }

    // Adiciona um subdiretório a este diretório
    public void addSubdirectory(Directory directory) {
        subdirectories.add(directory);
    }

    // Remove um subdiretório com base no nome
    public void removeSubdirectory(String name) {
        subdirectories.removeIf(directory -> directory.getName().equals(name));
    }

    // Retorna a lista de subdiretórios
    public List<Directory> getSubdirectories() {
        return subdirectories;
    }

    // Adiciona um arquivo a este diretório
    public void addFile(File file) {
        files.add(file);
    }

    // Remove um arquivo com base no nome
    public void removeFile(String name) {
        files.removeIf(file -> file.getName().equals(name));
    }

    // Retorna a lista de arquivos
    public List<File> getFiles() {
        return files;
    }

    // Procura um subdiretório pelo nome
    public Directory getSubdirectory(String name) {
        for (Directory subdirectory : subdirectories) {
            if (subdirectory.getName().equals(name)) {
                return subdirectory;
            }
        }
        return null; // Retorna null se não encontrar
    }

    // Procura um arquivo pelo nome
    public File getFile(String name) {
        for (File file : files) {
            if (file.getName().equals(name)) {
                return file;
            }
        }
        return null;
    }
}
