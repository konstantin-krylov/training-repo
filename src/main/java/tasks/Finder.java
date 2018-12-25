package tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        Path path = Paths.get("/Users", "konstantin", "Projects"); // заменить на args[0]
        Finder finder = new Finder(path);
        Map<String, List<String>> filesList = new HashMap<>();
        finder.findDuplicateFiles(filesList,path);
    }

    public void findDuplicateFiles(Map<String, List<String>> filesList, Path path) {
        final List<Path> files = new ArrayList<>();  // получаем список файлов из директории

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!attrs.isDirectory()) {
                        files.add(file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // если файлы одинаковы, складываем их в Мапу


    }

    @Override
    public boolean equals(Object obj) {
        boolean isDuplicate = true;
        try {
            FileInputStream fileContent1 = new FileInputStream(path.toString());
            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            FileInputStream fileContent2 = new FileInputStream(path.toString());
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

    @Override
    public int hashCode() {
        return path.hashCode();
    }
}

