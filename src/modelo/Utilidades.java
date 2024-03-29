/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ignacio
 */
public class Utilidades
{

    static public void Serializar(Object serializado)
    {
        try {
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bs);
            os.writeObject(serializado);  // this es de tipo DatoUdp
            os.close();
            byte[] bytes = bs.toByteArray(); // devuelve byte[]
            FileOutputStream fos = new FileOutputStream("UltimaSesion.bin");
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            System.out.println("Error al serializar: " + e);
        }
    }


    static public void SendTCP(Socket TCP, String datos)
    {
        try {
            DataOutputStream enviar_datos = new DataOutputStream(TCP.getOutputStream());
            enviar_datos.writeUTF(datos);
            enviar_datos.flush();
        } catch (Exception e) {
            System.out.println("Error Utilidades.SendTCP: " + e);
        }
    }

    static public String receiveTCP(Socket TCP)
    {
        try {
            DataInputStream recibir_datos = new DataInputStream(TCP.getInputStream());
            return recibir_datos.readUTF();
        } catch (Exception e) {
            System.out.println("Error Utilidades.ReceiveTCP: " + e);
            return "";
        }
    }

    static public Socket conectar(String ip)
    {
        try {
            Socket TCP = new Socket(ip, 1993);
            return TCP;
        } catch (Exception e) {
            System.out.println("Servidor no acepta conexiones.");
            return null;
        }
    }

    static public String receiveUDP(DatagramSocket UDP)
    {
    byte[] rec_bytes= new byte[256];
    DatagramPacket paquete = new DatagramPacket(rec_bytes, 256);
    String rec = "";

    //UDP.setSoTimeout(20000); <- Requisito configurar en toda conexión UDP
    
        try {
            UDP.receive(paquete);
        rec = (new String(rec_bytes).trim());
    }
    catch (SocketTimeoutException e) {
                    //Que hacer si no llega mensaje en el tiempo determinado
        } catch (IOException ex) {
            System.out.println("Error Utilidades.ReceiveUDP: "+ex);
        }
    return rec ;
}

    static public String getPublicIP(){
    String systemipaddress = ""; 
        try
        { 
            URL url_name = new URL("http://bot.whatismyipaddress.com"); 
  
            BufferedReader sc = 
            new BufferedReader(new InputStreamReader(url_name.openStream())); 
  
            // reads system IPAddress 
            systemipaddress = sc.readLine().trim(); 
            return systemipaddress.toString();
        } 
        catch (Exception e) 
        { 
            systemipaddress = "Cannot Execute Properly"; 
            return "Error en busqueda de IP";
        } 
    }
}
