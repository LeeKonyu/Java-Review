package JavaIO.file;

/**
 * @ClassName FileExample
 * @Description TODO
 * @Author
 * @Date 2020/8/10 18:30
 * @Version
 **/

import java.io.File;

/**
 * 磁盘操作
 */
public class FileExample {
    public static void listAllFiles(File dir){
        if (dir == null || !dir.exists()){
            return;
        }
        if (dir.isFile()){
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()){
            listAllFiles(file);
        }
    }

    public static void main(String[] args) {
        String path = "E:/CS-Notes-PDF/";
        File file = new File(path);
        listAllFiles(file);
    }
}
