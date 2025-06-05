// Importações de bibliotecas Java
import java.util.ArrayList;
import java.util.List;

// Classe que simula um sistema de arquivos com diretórios e arquivos
public class FileSystemSimulator {
    private Directory root; // Diretório raiz do sistema de arquivos
    private Directory currentDirectory; // Diretório atual onde o usuário está

    // Construtor: cria a raiz e define o diretório atual como sendo a raiz
    public FileSystemSimulator() {
        this.root = new Directory("root");
        this.currentDirectory = root;
    }

    // Cria uma nova pasta dentro do diretório atual
    public void createFolder(String name) {
        currentDirectory.addSubdirectory(new Directory(name));
    }

    // Cria um novo arquivo dentro do diretório atual
    public void createFile(String name, String content) {
        currentDirectory.addFile(new File(name, content));
    }

    // Deleta uma pasta pelo nome
    public void deleteFolder(String name) {
        currentDirectory.removeSubdirectory(name);
    }

    // Deleta um arquivo pelo nome
    public void deleteFile(String name) {
        currentDirectory.removeFile(name);
    }

    // Muda o diretório atual para um subdiretório com o nome especificado
    public void changeDirectory(String name) {
        Directory subdirectory = currentDirectory.getSubdirectory(name);
        if (subdirectory != null) {
            currentDirectory = subdirectory;
        } else {
            System.out.println("Diretório não encontrado.");
        }
    }

    // Volta ao diretório raiz
    public void resetToRoot() {
        currentDirectory = root;
    }

    // Retorna o diretório atual (onde o usuário está navegando)
    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    // Retorna o diretório raiz
    public Directory getRoot() {
        return root;
    }

    // Lista o conteúdo do diretório atual (subpastas e arquivos)
    public List<String> listCurrentDirectoryContents() {
        List<String> contents = new ArrayList<>();

        // Adiciona os nomes dos subdiretórios
        for (Directory subdirectory : currentDirectory.getSubdirectories()) {
            contents.add("[DIR] " + subdirectory.getName());
        }

        // Adiciona os nomes dos arquivos
        for (File file : currentDirectory.getFiles()) {
            contents.add("[FILE] " + file.getName());
        }

        return contents;
    }

    public void createFile(String fileName) {
        // Verifica se já existe um arquivo ou diretório com esse nome
        if (currentDirectory.getFile(fileName) != null || currentDirectory.getSubDirectory(fileName) != null) {
            System.out.println("Um arquivo ou diretório com esse nome já existe.");
            return;
        }

        // Cria o novo arquivo e adiciona ao diretório atual
        File newFile = new File(fileName);
        currentDirectory.addFile(newFile);

        // Registra a operação no journal
        journal.log("Criar Arquivo", fileName);

        System.out.println("Arquivo \"" + fileName + "\" criado com sucesso.");
    }

}