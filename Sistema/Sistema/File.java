package Sistema;

public class File {
    private String name;
    private String content;

    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Método para representar o arquivo como string (opcional, mas útil)
    @Override
    public String toString() {
        return "Arquivo: " + name + " | Conteúdo: " + content;
    }
}
