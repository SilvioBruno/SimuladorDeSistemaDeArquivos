package Sistema;

public class FileSystemSimulator {
    Directory root;

    public FileSystemSimulator() {
        root = new Directory("/");
    }

    public Directory searchDirectory(String path) {
        Directory current = root;
        String[] parts = path.split("/");

        for (String part : parts) {
            if (!part.isEmpty()) {
                boolean found = false;
                for (Directory d : current.getSubPastas()) {
                    if (d.getName().equals(part)) {
                        current = d;
                        found = true;
                        break;
                    }
                }
                if (!found) return null;
            }
        }
        return current;
    }

    public void createDirectory(String path, String name) {
        Directory dir = searchDirectory(path);
        if (dir != null) {
            if (dir.hasSubdirectory(name)) {
                System.out.println(" Diretório '" + name + "' já existe em " + path + ".");
            } else {
                dir.addPasta(name);
                System.out.println(" Diretório '" + name + "' criado com sucesso em " + path + ".");
            }
        } else {
            System.out.println(" Caminho não encontrado: " + path);
        }
    }

    public void createFile(String path, String name,  String content) {
        Directory dir = searchDirectory(path);
        if (dir != null) dir.addFile(name, content);
    }

    public void deleteFile(String path, String name) {
        Directory dir = searchDirectory(path);
        if (dir != null) dir.removeFile(name);
    }

    public void deleteDirectory(String path, String name) {
        Directory dir = searchDirectory(path);
        if (dir != null) dir.removePasta(name);
    }

    public void renameFile(String path, String oldName, String newName) {
        Directory dir = searchDirectory(path);
        if (dir != null) dir.renameFile(oldName, newName);
    }

    public void renameDirectory(String path, String oldName, String newName) {
        Directory dir = searchDirectory(path);
        if (dir != null) dir.renamePasta(oldName, newName);
    }

   public void copyFile(String path, String name, String newName, String path2) {
    Directory origin = searchDirectory(path);
    Directory destination = searchDirectory(path2);

    if (origin == null) {
        System.out.println("Diretório de origem não encontrado: " + path);
        return;
    }

    if (destination == null) {
        System.out.println("Diretório de destino não encontrado: " + path2);
        return;
    }

    File fileToCopy = origin.getFile(name);
    if (fileToCopy == null) {
        System.out.println("Arquivo '" + name + "' não encontrado em " + path);
        return;
    }

    if (destination.getFile(newName) != null) {
        System.out.println("Já existe um arquivo com o nome '" + newName + "' em " + path2);
        return;
    }

    destination.addFile(newName, fileToCopy.getContent());
    System.out.println("Arquivo '" + name + "' copiado para '" + path2 + "' como '" + newName + "'.");
}


    public void list(String path) {
        Directory dir = searchDirectory(path);
        if (dir != null) dir.list();
    }
}
