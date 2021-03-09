package virtualCommandPrompt;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// class to perform command prompt operations
public class CommandPrompt {
    Node root = new Node("root");
    Node currentDirectory = root;
    // method to create new directory
    boolean makeDirectory(String directoryName) {
        boolean result = false;
        if (!searchDirectory(directoryName, this.currentDirectory)) { 
            Node newDirectory = new Node(directoryName);
            newDirectory.parentNode = currentDirectory;
            currentDirectory.subDirectory.add(newDirectory);
            result = true;
        } else {
            System.out.println("Directory is already available.");
        }
        return result;
    }
    // method to search directory is available or not
    boolean searchDirectory(String directoryName, Node currentDirectory) {
        boolean result = false;
        for (int i = 0; i < currentDirectory.subDirectory.size(); i++) {
            if (currentDirectory.subDirectory.get(i).directoryName
                    .equals(directoryName)) {
                result = true;
            }
        }
        return result;
    }
    // method to print all directories
    List<List<String>> listAllDirectory() {
        List<List<String>> allDirectory = new ArrayList<List<String>>();
        List<String> currentFolders = new ArrayList<String>();
        List<String> subFolders = new ArrayList<String>();
        for (int i = 0; i < currentDirectory.subDirectory.size(); i++) {
            Node folder = currentDirectory.subDirectory.get(i);
            currentFolders.add(folder.directoryName + "  "
                    + folder.creationDate);
            for (int j = 0; j < folder.subDirectory.size(); j++) {
                subFolders.add(folder.subDirectory.get(j).directoryName + "  "
                        + folder.subDirectory.get(j).creationDate);
            }
        }
        allDirectory.add(currentFolders);
        allDirectory.add(subFolders);
        System.out.println(allDirectory);
        return allDirectory;
    }
    // method to change the directory
    void changeDirectory(String directoryName) {
        boolean find = false;
        for (int i = 0; i < currentDirectory.subDirectory.size(); i++) {
            if (currentDirectory.subDirectory.get(i).directoryName
                    .equals(directoryName)) {
                currentDirectory = currentDirectory.subDirectory.get(i);
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("No Such Directory Exists");
        }
    }
    // method to find a directory path
    List<String> findDirectory(String directoryName) {
        List<String> paths = new ArrayList<String>();
        findDirectoryPath(directoryName, root, paths);
        return paths;
    }
    // method to calculate directory path
    void findDirectoryPath(String directoryName, Node directory,
            List<String> paths) {
        for (int index = 0; index < directory.subDirectory.size(); index++) {
            if (directory.subDirectory.get(index).directoryName
                    .equals(directoryName)) {
                String path = "";
                Node pathFolder = directory.subDirectory.get(index).parentNode;
                while (pathFolder.parentNode != null) {   
                    path = pathFolder.directoryName + "\\" + path;
                    System.out.println("path--->" +path);
                    pathFolder = pathFolder.parentNode;
                }
                paths.add("root\\" + path);
            } else {
                findDirectoryPath(directoryName, directory.subDirectory.get(index),
                        paths);
            }
        }
    }
    // method to back to the parent directory
    void backToParentDirectory() {
        if (currentDirectory.parentNode == null) {
            System.out.println("You are in root directory");
        } else {
            currentDirectory = currentDirectory.parentNode;
        }
    }
    // method to display directory structure or Tree
    void displayDirectoryStructure(Node node) {
        try {
            if (node.subDirectory.size() == 0) {
                System.out.println();
                return;
            }
            for (Node i : node.subDirectory) {
                System.out.println(" " + i.directoryName);
                displayDirectoryStructure(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // method to display tree structure
    void displayDirectoryStructure() {
        displayDirectoryStructure(root);
    }
    // main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String commandInput;
        String[] command;
        CommandPrompt cp = new CommandPrompt();
        while (true) {
            try {
                System.out
                        .println("Enter Command:\tmkdir\tls\tcd\tbk\tfind\ttree\texit");
                commandInput = sc.nextLine();
                command = commandInput.split(" ");

                switch (command[0]) {
                case "mkdir":
                    cp.makeDirectory(command[1]);
                    break;
                case "ls":
                    List<List<String>> allFolders = cp.listAllDirectory();
                    List<String> currentFolders = allFolders.get(0);
                    List<String> subFolders = allFolders.get(1);
                    System.out.println("Current Directory: "
                            + cp.currentDirectory.directoryName);
                    System.out.println("Current Folders: ");
                    for (int index = 0;index < currentFolders.size(); index++) {
                        System.out.println(currentFolders.get(index));
                    }
                    System.out.println("Sub Folders: ");
                    for (int index = 0; index < subFolders.size(); index++) {
                        System.out.println(subFolders.get(index));
                    }
                    break;

                case "cd":
                    cp.changeDirectory(command[1]);
                    break;

                case "bk":
                    cp.backToParentDirectory();
                    break;

                case "find":
                    List<String> paths = cp.findDirectory(command[1]);
                    if (paths.size() == 0) {
                        System.out.println("Directory not available");
                    } else {
                        for (int i = 0; i < paths.size(); i++) {
                            System.out.println(paths.get(i));
                        }
                    }
                    break;

                case "tree":
                    cp.displayDirectoryStructure();
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Command Not Exists");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Command");
            }
        }
    }
}
