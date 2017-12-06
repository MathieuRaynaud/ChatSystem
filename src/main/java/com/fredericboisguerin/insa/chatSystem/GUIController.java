package com.fredericboisguerin.insa.chatSystem;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class GUIController {


    public Label labelNomUtilisateur = new Label();
    public TextFlow conversationEnCours = new TextFlow();
    public TextArea zoneEcritureMessage = new TextArea();
    public Button sendButton = new Button();

    private static GUIController instance;

    public GUIController() { instance=this; }



    public static GUIController getInstance() {
        return instance;
    }

    public void setNomUtilisateur(String nom){
        if (nom != null)
            labelNomUtilisateur.setText(nom);
        else
            labelNomUtilisateur.setText("Aucun nom trouve pour l'utilisateur");
    }

    public void onSendButtonClicked (){
        String tmp = zoneEcritureMessage.getText();
        Text text = new Text (tmp);
        conversationEnCours.getChildren().addAll(text);
        zoneEcritureMessage.clear();
    }
}
