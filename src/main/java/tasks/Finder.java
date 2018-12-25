package tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Finder {
    private static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("cannot initialize SHA-256 hash function", e);
        }
    }

    private Path path;

    public Finder(Path path) {
        this.path = path;
    }

    public static void main(String[] args) {
        Path path = Paths.get("/Users", "konstantin", "eclipse-workspace", "directory"); // заменить на args[0]
        Finder finder = new Finder(path);
        Map<Long, List<Path>> filesList = new HashMap<>(); // мапа с файлами для сравнения
        finder.directoryWalker(filesList, path);


        for (Map.Entry<Long, List<Path>> item : filesList.entrySet()) {

            Long key = item.getKey();
            List<Path> valueList = item.getValue();
            System.out.println("Key: " + key + " size " + valueList.size());

//            System.out.print("Values: ");
//            for (Path s : valueList) {
//                System.out.println(s + " ");
        }
    }


    public void directoryWalker(Map<Long, List<Path>> filesList, Path path) {

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!attrs.isDirectory()) {
                        List<Path> pathList = filesList.get(attrs.size());  // взять существующий List по ключу
                        if (pathList == null) {
                            pathList = new ArrayList<>(); // или создать новый
                        }
                        pathList.add(file);
                        filesList.put(attrs.size(), pathList);
                        System.out.println("file: " + file.toString() + " size " + attrs.size() + " bytes");
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean compare(Path path1, Path path2) {
        boolean isDuplicate = true;
        try {
            FileInputStream fileContent1 = new FileInputStream(path1.toString());
            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            FileInputStream fileContent2 = new FileInputStream(path2.toString());
            ByteBuffer buffer2 = ByteBuffer.allocate(1024);
            int m;
            int n;

            try {
                while ((m = buffer1.get(fileContent1.read())) != -1) {
                    n = buffer2.get(fileContent2.read());
                    if (m != n) {
                        isDuplicate = false;
                        break;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isDuplicate;
    }
}

