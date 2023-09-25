import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BackupFiles {
    public static void main(String[] args)  throws IOException{

        backupFiles("D:\\сортировать\\музыка\\релакс\\v\\",".\\backup");
//        backupFilesBadWay("D:\\сортировать\\музыка\\релакс\\v\\",".");
    }

    /**
     * Думаю это плохой способ копирования файлов, т.к. очень долгий
     * @param source исходный каталог, из которого копируются файлы
     * @param destination каталог назначения(не создаётся в случае отсуствия), куда из source копируются файлы
     * @throws IOException
     */
    public static void backupFilesBadWay(String source, String destination)  throws IOException {
        File[] files = new File(source).listFiles();

        if (files == null)
            return;

        for (File item: files) {
            if(item.isFile()) {
                try(FileInputStream sourceFile = new FileInputStream(item.getCanonicalFile())){
                    int c;
                    try(FileOutputStream destinationFile = new FileOutputStream(destination+"\\"+item.getName())){
                        while ( (c = sourceFile.read()) != -1)
                            destinationFile.write(c);
                    }
                }
            }

        }
    }

    /**
     * Хороший способ копирования файлов, т.к. быстрый.
     * @param source исходный каталог, из которого копируются файлы
     * @param destination каталог назначения(создаётся в случае отсутствия), куда из source копируются файлы
     * @throws IOException
     */
    public static void backupFiles(String source, String destination)  throws IOException {
        File[] files = new File(source).listFiles();
        Path fileDestination =  Paths.get(destination);

        if (files == null)
            return;

        if(!Files.exists(fileDestination))
            Files.createDirectories(fileDestination);

        for (File item: files) {
            if(item.isFile()) {
                Files.copy(Paths.get(item.getCanonicalFile().toURI()), Paths.get(destination+"\\"+item.getName()));
            }

        }
    }
}
