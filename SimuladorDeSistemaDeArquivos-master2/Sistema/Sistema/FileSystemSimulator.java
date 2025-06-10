package Sistema;

import java.io.*;

public class FileSystemSimulator {
    private Directory root;
    private static final String SAVE_PATH = "filesystem.dat";

    public FileSystemSimulator() {
        load();
        if (root == null) {
            root = new Directory("/");
        }
    }

    // Salvar estado
    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH))) {
            oos.writeObject(root);
            System.out.println("Sistema de arquivos salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o sistema de arquivos: " + e.getMessage());
        }
    }

    // Carregar estado
    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_PATH))) {
            root = (Directory) ois.readObject();
            System.out.println("Sistema de arquivos carregado com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum sistema de arquivos salvo encontrado ou erro ao carregar.");
        }
    }

    private Directory findDirectory(String path) {
        String[] parts = path.split("/");
        Directory current = root;

        for (String part : parts) {
            if (!part.isEmpty()) {
                current = current.getSubDirectory(part);
                if (current == null) {
                    break;
                }
            }
        }

        return current;
    }

    public void createDirectory(String path, String name) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.addDirectory(new Directory(name));
            System.out.println("Diretório criado: " + name);
            Journal.log("Criar Diretório", path + "/" + name);
        } else {
            System.out.println("Diretório não encontrado: " + path);
        }
    }

    public void createFile(String path, String name, String content) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.addFile(new File(name, content));
            System.out.println("Arquivo criado: " + name);
            Journal.log("Criar Arquivo", path + "/" + name);
        } else {
            System.out.println("Diretório não encontrado: " + path);
        }
    }

    public void deleteFile(String path, String name) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.removeFile(name);
            System.out.println("Arquivo removido: " + name);
            Journal.log("Deletar Arquivo", path + "/" + name);
        } else {
            System.out.println("Diretório não encontrado: " + path);
        }
    }

    public void deleteDirectory(String path, String name) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.removeDirectory(name);
            System.out.println("Diretório removido: " + name);
            Journal.log("Deletar Diretório", path + "/" + name);
        } else {
            System.out.println("Diretório não encontrado: " + path);
        }
    }

    public void renameFile(String path, String oldName, String newName) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            File file = dir.getFile(oldName);
            if (file != null) {
                file.setName(newName);
                System.out.println("Arquivo renomeado: " + oldName + " -> " + newName);
                Journal.log("Renomear Arquivo", path + "/" + oldName + " -> " + newName);
            } else {
                System.out.println("Arquivo não encontrado: " + oldName);
            }
        } else {
            System.out.println("Diretório não encontrado: " + path);
        }
    }

    public void renameDirectory(String path, String oldName, String newName) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            Directory subDir = dir.getSubDirectory(oldName);
            if (subDir != null) {
                subDir.setName(newName);
                System.out.println("Diretório renomeado: " + oldName + " -> " + newName);
                Journal.log("Renomear Diretório", path + "/" + oldName + " -> " + newName);
            } else {
                System.out.println("Diretório não encontrado: " + oldName);
            }
        } else {
            System.out.println("Diretório não encontrado: " + path);
        }
    }

    public void copyFile(String sourcePath, String fileName, String destPath, String newFileName) {
        Directory srcDir = findDirectory(sourcePath);
        Directory destDir = findDirectory(destPath);

        if (srcDir != null && destDir != null) {
            File file = srcDir.getFile(fileName);
            if (file != null) {
                destDir.addFile(new File(newFileName, file.getContent()));
                System.out.println("Arquivo copiado para: " + destPath + "/" + newFileName);
                Journal.log("Copiar Arquivo", sourcePath + "/" + fileName + " -> " + destPath + "/" + newFileName);
            } else {
                System.out.println("Arquivo não encontrado: " + fileName);
            }
        } else {
            System.out.println("Diretório de origem ou destino não encontrado.");
        }
    }

    public void list(String path) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            System.out.println("Conteúdo de " + path + ":");
            for (Directory d : dir.getSubDirectories()) {
                System.out.println("[DIR] " + d.getName());
            }
            for (File f : dir.getFiles()) {
                System.out.println("[FILE] " + f.getName());
            }
        } else {
            System.out.println("Diretório não encontrado: " + path);
        }
    }
}
