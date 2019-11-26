package demo1;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        try{
            String sourcepath = "C:/code/java/learn01/IOStream/src/source.txt";
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(sourcepath)
            );
            String distpath = "dist.txt";
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(distpath)
            );
            byte[] buffer = new byte[10];
            int len = bis.read(buffer);
            while(len != -1){
                bos.write(buffer);
                len = bis.read(buffer);
            }
            bos.close();
            bis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
