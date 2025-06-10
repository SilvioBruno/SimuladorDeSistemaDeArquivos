package Sistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Directory implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private List<File> files;
    private List<Directory> subDirectories;

    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.subDirectories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Directory> getSubDirectories() {
        return subDirectories;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void removeFile(String fileName) {
        files.removeIf(file -> file.getName().equals(fileName));
    }

    public void addDirectory(Directory dir) {
        subDirectories.add(dir);
    }

    public void removeDirectory(String dirName) {
        subDirectories.removeIf(dir -> dir.getName().equals(dirName));
    }

    public Directory getSubDirectory(String dirName) {
        for (Directory dir : subDirectories) {
            if (dir.getName().equals(dirName)) {
                return dir;
            }
        }
        return null;
    }

    public File getFile(String fileName) {
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }
}
