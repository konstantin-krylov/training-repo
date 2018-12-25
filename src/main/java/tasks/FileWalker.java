package tasks;

import java.io.File;

public class FileWalker {
    public void walk(String path) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {

            if (f.isDirectory()) {
                walk(f.getAbsolutePath());
                System.out.println("Dir: " + f.getAbsolutePath());
            } else {
                System.out.println("File: " + f.getAbsoluteFile());
            }
        }

    }

    public static void main(String[] args) {
        FileWalker fw = new FileWalker();
        fw.walk("/Users/irina/git/training-repo/src/main/");
    }
}
