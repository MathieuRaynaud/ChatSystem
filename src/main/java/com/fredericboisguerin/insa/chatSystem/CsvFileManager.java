package com.fredericboisguerin.insa.chatSystem;

import java.io.*;
import java.util.*;

public class CsvFileManager {

    public String pathname;
    public File file;
    private FileWriter fileWriter;

    CsvFileManager(String path) throws IOException{
        pathname = path;
        file = new File(pathname);
        fileWriter = new FileWriter(file,true);
    }

    public static List<String> readFile(File file) throws IOException {

        List<String> result = new ArrayList<String>();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            result.add(line);
        }

        br.close();
        fr.close();

        return result;
    }

    public void writeParagraphInFile(Vector<String> Paragraph) throws IOException{
        
        Iterator<String> it = Paragraph.iterator();

        while(it.hasNext()){
            String s = it.next();
            fileWriter.write(s);
        }
        fileWriter.write(";");
    }

}
