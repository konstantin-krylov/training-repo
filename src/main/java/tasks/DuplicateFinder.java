package tasks;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


public class DuplicateFinder {

    private Path path;

    public DuplicateFinder(Path path) {
        this.path = path;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please, supply a directory path");
            return;
        }
        Path path = Paths.get(args[0]);

        DuplicateFinder duplicateFinder = new DuplicateFinder(path);
        Map<Long, List<Path>> filesList = new HashMap<>();
        duplicateFinder.directoryWalker(filesList, path);


        for (Map.Entry<Long, List<Path>> item : filesList.entrySet()) {

            List<Path> valueList = item.getValue();
            if (valueList.size() > 1) {
                duplicateFinder.findDuplicates(valueList, item.getKey());
            }

        }
    }

    private void directoryWalker(Map<Long, List<Path>> filesList, Path path) {

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!attrs.isDirectory()) {
                        List<Path> pathList = filesList.get(attrs.size());
                        if (pathList == null) {
                            pathList = new ArrayList<>();
                            filesList.put(attrs.size(), pathList);
                        }
                        pathList.add(file);

                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findDuplicates(List<Path> paths, Long size) {
        for (int i = 0; i < paths.size(); i++) {
            for (int j = i + 1; j < paths.size(); j++) {
                if (compare(paths.get(i), paths.get(j))) {
                    System.out.println("ORIGINAL FILE: " + paths.get(i));
                    System.out.println("DUPLICATE FILE: " + paths.get(j));
                    System.out.println("FILE SIZE: " + size + " bytes" + "\n");
                }
            }
        }
    }


    private boolean compare(Path path1, Path path2) {
        boolean isDuplicate = true;
        try (final FileInputStream fileContent1 = new FileInputStream(path1.toString())) {
            try (final FileInputStream fileContent2 = new FileInputStream(path2.toString())) {
                int m, n;

                while ((m = fileContent1.read()) != -1) {
                    n = fileContent2.read();
                    if (m != n) {
                        isDuplicate = false;
                        break;
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
        return isDuplicate;
    }
}


