package utility;

import beans.Config;
import beans.User;
import config.Initializer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagerSystem {

    public static Config readConfig() {
        return (Config) ReadFileIO.readFileDeserialize(Config.fileName);
    }

    public static boolean refreshConfig() {
        return WriteToFileIO.writeObjectToFile(Initializer.config, Config.fileName);
    }

    public static void printAllSubFilesAndFolders() {
        String path = askForPath();
        boolean hasAccess = checkUserAccessToFile(path);
        if (hasAccess) {
            printAllSubFilesAndFolders(path);
        } else {
            System.out.println("You don't have an access");
        }
    }

    public static void printAllSubFilesAndFolders(String folderPath) {
        //bu methoda gonderilen folder path-in ichinde olan butun folder ve file adlarini alt-alta printe versin
        File f = new File(folderPath);
        Path file = f.toPath();
        // boolean exists = Files.exists(file);        // Check if the file exists
        boolean isDirectory = Files.isDirectory(file);   // Check if it's a directory
        boolean isFile = Files.isRegularFile(file); // Check if it's a regular file
        if (isDirectory) {
           File[] subFiles=  f.listFiles();
           for(File subF:subFiles){
               System.out.println(subF.getAbsolutePath());
           }
        } else if (isFile) {
            System.out.println(folderPath);
        }
    }

    public static String askForPath() {
        //mushteriden daxil olmasini istediyi file ve ya folderin adini isteyeceksiniz
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter File or Folder name: ");
        String path = scan.nextLine();
        return path;
    }

    public static boolean checkUserAccessToFile(String fileOrFolderPath) {
        User user = getLoggedInUser();
        List<String> nonAccessibleFileOrFolders = user.getNonAccessableFilesOrFolders();
        boolean hasAccess = !nonAccessibleFileOrFolders.contains(fileOrFolderPath);
        return hasAccess;
    }

    public static void setNonAccessibleFileOrFoldersForUser() {
        String userId = UserSystem.askForUserId();
        User user = UserSystem.getUserById(userId);
        List<String> naf = getAllNonAccessibeFileOrFolders();
        user.setNonAccessableFilesOrFolders(naf);
        UserSystem.save(user);
    }

    public static List<String> getAllNonAccessibeFileOrFolders() {
        //burada adminden accessi olmayan file ve folderlerin listini return edirsiniz scanner ile alib return edirsiniz.
        Scanner scan = new Scanner(System.in);
        System.out.println("How many file or folder you want to ignore?");
        int count = scan.nextInt();
        System.out.println("Please insert non access files or folders directory: ");
        scan.nextLine();
        String nonAccesFileOrFolders = scan.nextLine();
        List<String> nonAccesFileslist = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            nonAccesFileslist.add(i, nonAccesFileOrFolders);
        }
        return nonAccesFileslist;
    }


    public static User getLoggedInUser() {
        return Initializer.config.getLoggedInUser();
    }
}
