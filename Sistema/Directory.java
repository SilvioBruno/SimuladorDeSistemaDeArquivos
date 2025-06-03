package Sistema;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String name;
    List<Directory> subPasta = new ArrayList<>();
    List<File> arquivos = new ArrayList<>();
    
    public Directory(String name){
        this.name = name;
    }

    public void addFile(String name, String ext, String content){
        File file = new File(name, ext, content);
        arquivos.add(file);

        System.out.println("Arquivo Adicionado Com Sucesso!!!");
    }

    public void addPasta(String name){
        Directory newDir = new Directory(name);
        subPasta.add(newDir);
    
        System.err.println("Pasta adicionada com sucesso!!!");
    }

}
