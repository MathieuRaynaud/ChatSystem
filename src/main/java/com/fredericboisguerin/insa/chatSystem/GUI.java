package com.fredericboisguerin.insa.chatSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.ComponentOrientation;

import static java.awt.BorderLayout.*;

public class GUI extends JFrame {

    private Messagerie messagerieAssociee;
    public JPanel contentPane;
    public JPanel launchPane;

    public GUI() {
        super("Application de Chat");

        this.messagerieAssociee = new Messagerie();
        this.contentPane = new JPanel();
        this.launchPane = new JPanel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void afficherLaunchPage() {
        this.launchPane = new JPanel();
        setContentPane(launchPane);

        JLabel enterPseudoLabel = new JLabel("Entrez votre pseudonyme :");
        JLabel launchTitreLabel = new JLabel("Système de Chat");

        JPanel layoutPane = new JPanel(new GridLayout(2,1));
        JPanel choosePseudoPane = new JPanel(new GridLayout(2,1));
        JPanel enterAndSendPane = new JPanel(new GridLayout(1,2));

        layoutPane.add(launchTitreLabel);
        layoutPane.add(choosePseudoPane);

        choosePseudoPane.add(enterPseudoLabel);
        choosePseudoPane.add(enterAndSendPane);

        JTextField pseudoTextField = new JTextField(20);
        JButton sendPseudoButton = new JButton("Choisir");
        sendPseudoButton.addActionListener(e ->  this.onChoisirPseudoButtonClicked());

        enterAndSendPane.add(pseudoTextField);
        enterAndSendPane.add(sendPseudoButton);

        launchPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(launchPane);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void afficherMainPage() {
        setContentPane(contentPane);

        JPanel globalPane = new JPanel(new GridLayout(2, 1));
        JPanel southPane = new JPanel(new GridLayout(1,2));
        JPanel informationPane = new JPanel(new GridLayout(1, 0));
        JPanel usersPane = new JPanel(new GridLayout(0, 1));
        JPanel conversationPane = new JPanel(new GridLayout(2, 1));
        JPanel bufferPane = new JPanel(new GridLayout(1,2));
        JPanel infoAboutUserPane  = new JPanel(new GridLayout(2,1));

        JButton sendButton = new JButton("Envoyer");
        sendButton.addActionListener(e ->  this.messagerieAssociee.onSendButtonClicked("Coucou", messagerieAssociee.listOfContactsWithConversations.get(1)));
        JButton changerPseudoButton = new JButton("Changer");
        changerPseudoButton.addActionListener(e ->  this.messagerieAssociee.onSendButtonClicked("Coucou", messagerieAssociee.listOfContactsWithConversations.get(1)));
        JButton parametresButton = new JButton("Paramètres");
        sendButton.addActionListener(e ->  this.onParametresButtonClicked());

        // Mise en place du Panel d'informations (en haut)
        JLabel titreLabel = new JLabel("Système de Chat");
        JLabel pseudoLabel = new JLabel("Pseudo :");

        // Mise en place du Panel des utilisateurs connectés
        JLabel utilisateursConnectesLabel = new JLabel("Utilisateurs connectés :");
        JLabel utilisateursHorsLigneLabel = new JLabel("Utilisateurs hors ligne :");

        usersPane.add(utilisateursConnectesLabel);
        usersPane.add(utilisateursHorsLigneLabel);
        usersPane.setBorder(BorderFactory.createEtchedBorder());

        //Mise en place du Panel de conversation
        JLabel conversationLabel = new JLabel("Conversation :");
        JTextField bufferTextField = new JTextField(20);
        bufferTextField.setToolTipText("Ecrivez ici");

        //Mise en page ------------------------------------------------------------------------------------------------

        infoAboutUserPane.add(pseudoLabel);
        infoAboutUserPane.add(changerPseudoButton);
        informationPane.add(infoAboutUserPane);
        informationPane.add(titreLabel);
        informationPane.add(parametresButton, EAST);
        informationPane.setBorder(BorderFactory.createEtchedBorder());

        bufferPane.add(bufferTextField);
        bufferPane.add(sendButton);


        conversationPane.add(conversationLabel);
        conversationPane.add(bufferPane);
        conversationPane.setBorder(BorderFactory.createEtchedBorder());

        globalPane.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        southPane.add(usersPane);
        southPane.add(conversationPane);

        globalPane.add(informationPane);
        globalPane.add(southPane);

        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPane);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


    public void onParametresButtonClicked() {

    }

    public void onChoisirPseudoButtonClicked() {

    }

    public void afficherConversation() {


    }
}
