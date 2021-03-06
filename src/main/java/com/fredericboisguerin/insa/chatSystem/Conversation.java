package com.fredericboisguerin.insa.chatSystem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;


public class Conversation {

    // ATTRIBUTS

    private Utilisateur utilisateurDistant;
    private ArrayList<String> conversation;

    // CONSTRUCTEUR

    public Conversation(Utilisateur utilisateur) {
            this.utilisateurDistant = utilisateur;
            //this.conversation = recupererHistorique(utilisateur);
            this.conversation = new ArrayList<String>();

    }

    // METHODES

    public void fermerConversation(){
        enregistrerConversation();
    }

    public ArrayList<String> recupererHistorique(Utilisateur utilisateurDistant) throws IOException {
        ArrayList<String> hist = new ArrayList<String>();
        CSVReader reader = new CSVReader(new FileReader("contacts.csv"));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        }
        return hist;
    }

    public void ajouterMessage(String msg) {
        conversation.add(msg);
    }

    public void enregistrerConversation (){
        ArrayList<String> conv = new ArrayList<String>();
    }

}
