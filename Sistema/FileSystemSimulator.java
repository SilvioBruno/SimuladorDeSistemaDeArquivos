package Sistema;

public class FileSystemSimulator {
    Directory root;

    public FileSystemSimulator(){
        root = new Directory("/");
    }

    public Directory SearchDirectory(String path){

        Directory current = root;

        String[] divisions = path.split("/");

        for (int i = 0; i < divisions.length; i++) {
            String division = divisions[i];

            if (!division.isEmpty()) {
                boolean found = false;

                for (int j = 0; j < current.subPasta.size(); j++) {
                    Directory sub = current.subPasta.get(j);

                    if (sub.name.equals(division)) {
                        current = sub;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    return null;
                }

            }
        }

        return current;

    }

    public void CreateDirectory(String path, String name){
        Directory Dir = SearchDirectory(path);
        if (Dir != null) {
            Dir.addPasta(name);
        }
    }
}
