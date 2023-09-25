import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tree {

    public static void main(String[] args) {

//        print(new File("."), "", true);
        print(new File("D:\\сортировать\\музло\\"), "", true);

    }

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += " ";
        }
        else{
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        List<File> subFiles = new ArrayList<>();

        int subFilesTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isFile()){
                subFilesTotal++;
                subFiles.add(files[i]);
            }
        }

        int subDirTotal2 = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
                subDirTotal2++;
        }

        if(subFiles.size()>0){
            for (File item: subFiles) {
                System.out.print(indent);
                if(--subFilesTotal == 0)
                    if(subDirTotal2 == 0)
                        System.out.print(" └─");
                    else
                        System.out.print("│ └─");
                else
                if(subDirTotal2 == 0)
                    System.out.print(" ├─");
                else
                    System.out.print("│ ├─");
                System.out.println(item.getName());
            }
        }

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
                subDirTotal++;
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                subDirCounter++;
                print(files[i], indent, subDirCounter == subDirTotal);
            }
        }

    }
}
