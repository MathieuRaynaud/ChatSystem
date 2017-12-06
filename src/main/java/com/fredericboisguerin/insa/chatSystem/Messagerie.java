package com.fredericboisguerin.insa.chatSystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.util.HashMap;


public class Messagerie {



    //Déclaration constantes
    final private int PORT_ECOUTE_UDP = 5555;
    final private int PORT_ECOUTE_TCP = 6666;

    //Déclatarion variables
    public Utilisateur moi;
    public HashMap<InetAddress, Utilisateur> mapUsersByIP;

    //Constructeur
    public Messagerie (Utilisateur myself){
        mapUsersByIP = new HashMap<InetAddress, Utilisateur>();
        this.moi = myself;
    }

<<<<<<< HEAD
    //Lance l'interface graphique et les deux écoutes
    public void go() throws IOException{
=======
    public void go() {
            GUI monBeauGUI = new GUI();
            monBeauGUI.afficherLaunchPage();
            monBeauGUI.afficherMainPage();

            Thread UDPlistenThread = new Thread(() -> {
                try {
                    this.listenOnUDPPort();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            Thread TCPlistenThread = new Thread(() -> {
                try {
                    this.listenOnTCPPort();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
    }
>>>>>>> 2fbe48ea760da52233c7236ac822a87bb8b73cd8

        Thread UDPlistenThread = new Thread(() -> {
            try {
                this.listenOnUDPPort();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread TCPlistenThread = new Thread(() -> {
            try {
                this.listenOnTCPPort();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



    }

    //Envoie un message quand le bouton envoyer est actionné
    public void onSendButtonClicked(String message, Utilisateur distantUser) {
        Thread envoiMessageThread = new Thread(() -> { sendMessage(message, distantUser.ipAdress); });
    }



    //Ecoute de la connection UDP de nouveaux utilisateurs
    public void listenOnUDPPort() throws Exception {
        try{

            byte[] buf = new byte[8196];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            DatagramSocket ds = new DatagramSocket(PORT_ECOUTE_UDP);
            System.out.println("I'm listening, boss.");
            while (true) {
                ds.receive(dp);
                String msgrecu = new String(dp.getData(), 0, dp.getLength());
                System.out.println("Ajout de l'utilisateur " + msgrecu);
                ajouterPersonne(msgrecu, dp.getAddress(), dp.getPort());
            }


        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public void notifyOthersOfMyPresence() {
        String message = moi.pseudonyme;
        byte[] msg = message.getBytes();
        try {
            InetAddress adresseDeBroadcast = InetAddress.getByName("255.255.255.255");
            DatagramPacket dp = new DatagramPacket(msg, msg.length, adresseDeBroadcast, PORT_ECOUTE_UDP);
            DatagramSocket ds = new DatagramSocket();
            System.out.println("Notification datagram sent.");
            ds.send(dp);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    //Ecouter les messages entrants sur le port TCP
    public void listenOnTCPPort() {
        try {
            ServerSocket socketServeur = new ServerSocket(PORT_ECOUTE_TCP);
            System.out.println("Ecoute de messages entrants...");
            while (true) {
                Socket socketClient = socketServeur.accept();
                String message = new String("");
                BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
                PrintStream out = new PrintStream(socketClient.getOutputStream());
                message = in.readLine();
                System.out.println("Connexion établie avec " + socketClient.getInetAddress());
                System.out.println("Chaîne reçue : " + message + "\n");
                ajouterMessage(socketClient.getInetAddress(), message);
                socketClient.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Envoyer message par TCP
    public void sendMessage(String message, InetAddress ipAddress) {
        try {
            Socket socket = new Socket(ipAddress, PORT_ECOUTE_TCP);
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Ajour d'un message entrant à la conversation
    private void ajouterMessage (InetAddress ip, String message) {
        if (mapUsersByIP.containsValue(ip))
            mapUsersByIP.get(ip).conv.ajouterMessage(message);

    }

    //Ajout d'un contact à la liste
    private void ajouterPersonne(String nom, InetAddress ip, int port) {
        mapUsersByIP.put(ip,new Utilisateur(nom, ip, port));
    }




}
