package com.fredericboisguerin.insa.chatSystem;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;


public class Conversation {

    // ATTRIBUTS

    private FileManager fileManager;
    private Utilisateur utilisateurDistant;
    private ArrayList<String> conversation;
    private ArrayList<StringTuple> sauvegarde;

    // CONSTRUCTEUR

    public Conversation(Utilisateur utilisateur) {
            this.utilisateurDistant = utilisateur;
            //this.conversation = recupererHistorique(utilisateur);
            this.conversation = new ArrayList<String>();
            this.sauvegarde = new ArrayList<StringTuple>();
    }

    // METHODES

    public ArrayList<String> recupererHistorique(Utilisateur utilisateurDistant) throws IOException {
        ArrayList<String> hist = new ArrayList<String>();
        CSVReader reader = new CSVReader(new FileReader("contacts.csv"));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        }
        return hist;
    }

    public void ajouterMessage(String emetteur, String msg) {
        if (emetteur != "Moi") conversation.add(msg);
        //On crée un tuple contenant l'emetteur du message et le message lui-meme, et on le sauvegarde dans la conversation
        StringTuple temp = new StringTuple(emetteur,msg);
        sauvegarde.add(temp);
    }

    public void enregistrerConversation (){
        fileManager.getInstance().saveConv(utilisateurDistant.pseudonyme, sauvegarde);
    }

}
