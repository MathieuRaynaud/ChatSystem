package com.fredericboisguerin.insa.chatSystem;

import java.io.*;
import java.util.*;

import static java.io.File.separator;
import static java.io.File.separatorChar;

public class FileManager{


    private static FileManager instance;

    public FileManager() { instance=this; }

    public static FileManager getInstance() { return instance; }


   public void saveConv(String utilisateur, ArrayList<StringTuple> conversation) {
       try {
           // Nous prenons comme convention que chaque utilisateur distant a un fichier nomme sonNom.txt dans le dossier data ou toute la conversation est sauvegarde
           String pathname = new File("").getAbsolutePath();
           File ConvFile = new File(pathname + utilisateur+".txt");
           ConvFile.setWritable(true);

           FileWriter stylo = new FileWriter(ConvFile, true);
           Iterator<StringTuple> it = conversation.iterator();

           if (ConvFile.exists() == true) ConvFile.delete();

           ConvFile.createNewFile();
           while (it.hasNext()) {
               StringTuple actuel = it.next();
               String aEcrire = (actuel.nom + " SAID := " + actuel.msg);
               stylo.write(aEcrire);
           }

       } catch (Exception e){
           e.printStackTrace();
       }
   }

}
