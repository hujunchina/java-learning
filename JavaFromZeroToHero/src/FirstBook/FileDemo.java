package FirstBook;

import java.io.*;

public class FileDemo {
    private File f = null;
    public FileDemo(File f){
        this.f = f;
    }
    public void creteFile(){
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteFile(){
        f.delete();
    }
    public void createFold(){
        if(f.isDirectory()){
            f.mkdir();
        }
    }
    public void listFiles(){
        String str[] = f.list();
        for(String s:str){
            System.out.println(str);
        }
    }
    public void show(){
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
    }

    public void writeLine(String line) throws IOException {
        OutputStream out = new FileOutputStream(f);
        out.write(line.getBytes());
        out.close();
    }
    public void writeAppendLine(String line) throws IOException {
        OutputStream out = new FileOutputStream(f, true);
        out.write(line.getBytes());
        out.close();
    }
    public String readLine() throws IOException {
       String line = null;
       InputStream input = new FileInputStream(f);
       byte[] b = new byte[1024];
       input.read(b);
       input.close();
       line = new String(b);
       input.close();
       return line;
    }
    public byte[] readBytes() throws IOException {
        byte[] line = new byte[(int)f.length()];
        InputStream input = new FileInputStream(f);
        int i=0;
        while(input.read()!=-1){
            line[i++] = (byte)input.read();
        }
        input.close();
        return line;
    }
    public void writeWord(String line) throws IOException {
        Writer writer = new FileWriter(f);
        writer.write(line);
        writer.append(line);
        writer.close();
    }
    public String readWord() throws IOException {
        String line = null;
        Reader reader = new FileReader(f);
        char c[] = new char[1024];
        int len = reader.read(c);
        reader.close();
        line = new String(c, 0, len);
        return line;
    }
    public void streamWriter(String line) throws IOException {
        Writer out = new OutputStreamWriter(new FileOutputStream(f));
        out.write(line);
    }
}
