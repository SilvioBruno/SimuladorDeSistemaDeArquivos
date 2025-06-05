package Sistema;

import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        FileSystemSimulator fs = new FileSystemSimulator();
        Scanner sc = new Scanner(System.in);
        String cmd;

        System.out.println("Bem-vindo ao Simulador de Sistema de Arquivos.");
        System.out.println("Digite 'exit' para sair.");

        while (true) {
            System.out.print("> ");
            cmd = sc.nextLine();
            if (cmd.equals("exit")) break;

            String[] parts = cmd.split(" ");

            try {
                switch (parts[0]) {
                    case "mkdir":
                        fs.createDirectory(parts[1], parts[2]);
                        break;
                    case "touch":
                        fs.createFile(parts[1], parts[2], parts[3]);
                        break;
                    case "rmfile":
                        fs.deleteFile(parts[1], parts[2]);
                        break;
                    case "rmdir":
                        fs.deleteDirectory(parts[1], parts[2]);
                        break;
                    case "renamefile":
                        fs.renameFile(parts[1], parts[2], parts[3]);
                        break;
                    case "renamedir":
                        fs.renameDirectory(parts[1], parts[2], parts[3]);
                        break;
                    case "cpfile":
                        fs.copyFile(parts[1], parts[2], parts[3], parts[4]);
                        break;
                    case "ls":
                        fs.list(parts[1]);
                        break;
                    default:
                        System.out.println("Comando inválido.");
                }
            } catch (Exception e) {
                System.out.println("Erro no comando. Verifique os parâmetros.");
            }
        }

        sc.close();
    }
}
