// Representa um arquivo no sistema de arquivos simulado
public class File {
    private String name; // Nome do arquivo
    private String content; // Conteúdo do arquivo

    // Construtor: inicializa o arquivo com nome e conteúdo
    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }

    // Retorna o nome do arquivo
    public String getName() {
        return name;
    }

    // Retorna o conteúdo do arquivo
    public String getContent() {
        return content;
    }

    // Define novo conteúdo para o arquivo
    public void setContent(String content) {
        this.content = content;
    }
}
