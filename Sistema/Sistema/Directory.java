package Sistema;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    private List<Directory> subPastas = new ArrayList<>();
    private List<File> arquivos = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Directory> getSubPastas() {
        return subPastas;
    }

    public File getFile(String name) {
        for (File f : arquivos) {
            if (f.getName().equalsIgnoreCase(name)) {
                return f;
            }
        }
        return null;
    }

    public void addFile(String name, String content) {
        if (getFile(name) != null) {
            System.out.println("Arquivo '" + name + "' já existe neste diretório.");
        } else {
            arquivos.add(new File(name, content));
            Journal.log("Criar Arquivo", name);
            System.out.println("Arquivo '" + name + "' criado.");
        }
    }

    public void addPasta(String name) {
        if (hasSubdirectory(name)) {
            System.out.println(" A pasta '" + name + "' já existe neste diretório.");
        } else {
            Directory newDir = new Directory(name);
            subPastas.add(newDir);
            Journal.log("Criar Pasta", name);
            System.out.println(" Pasta '" + name + "' criada.");
        }
    }

    public boolean hasSubdirectory(String name) {
        for (Directory sub : subPastas) {
            if (sub.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void removeFile(String name) {
        arquivos.removeIf(f -> f.getName().equalsIgnoreCase(name));
        Journal.log("Deletar Arquivo", name);
    }

    public void removePasta(String name) {
        subPastas.removeIf(p -> p.getName().equalsIgnoreCase(name));
        Journal.log("Deletar Pasta", name);
    }

    public void renameFile(String oldName, String newName) {
        File file = getFile(oldName);
        if (file != null) {
            file.setName(newName);
            Journal.log("Renomear Arquivo", oldName + " -> " + newName);
        }
    }

    public void renamePasta(String oldName, String newName) {
        for (Directory d : subPastas) {
            if (d.getName().equalsIgnoreCase(oldName)) {
                d.name = newName;
                Journal.log("Renomear Pasta", oldName + " -> " + newName);
                break;
            }
        }
    }

    public void copyFile(String name, String newName) {
        File file = getFile(name);
        if (file != null) {
            addFile(newName, file.getContent());
            Journal.log("Copiar Arquivo", name + " -> " + newName);
        }
    }

    public void list() {
        System.out.println("Pastas:");
        for (Directory d : subPastas) {
            System.out.println("- " + d.getName());
        }
        System.out.println("Arquivos:");
        for (File f : arquivos) {
            System.out.println("- " + f.getName());
        }
    }
}
