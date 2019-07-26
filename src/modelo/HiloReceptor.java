/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vistas.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ignacio
 */
public class HiloReceptor extends Thread
{

    private Socket TCP;
    ServerSocket server;

    
    public HiloReceptor()
    {
        TCP = null;
    }

    public Socket Conectar()
    {
        boolean conected = false;
        while (!conected) {
            try {
                server = new ServerSocket(1993);
                TCP = server.accept();
                conected = true;
                server.close();
            } catch (IOException e) {
                System.out.println("Error HiloReceptor.Conectar: " + e);
            }
        }
        return TCP;
    }

    public Socket getTCP()
    {
        return TCP;
    }

    public HiloReceptor(Socket TCP)
    {
        this.TCP = TCP;
    }

    @Override
    public void run()
    {
        if (TCP == null) {
            TCP = Conectar();
            System.out.println(TCP.getInetAddress() + "/" + TCP.getLocalAddress());
        }

        while (true) {
            procesar(Utilidades.receiveTCP(TCP));
        }
    }

    private void procesar(String cadena)
    {
        System.out.println("Mensaje recibido: " + cadena);
        if(cadena!=null)
        if (cadena.length() > 0) {
            switch (cadena.charAt(0)) {
                case '0': //Mensaje de chat
                {
                    String mensaje=(cadena.substring(2,cadena.length()));
                    break;
                }
                case '1': //Protocolos de conexion
                {
                    switch (cadena.charAt(2)) {
                        case '1': 
                        {
                            break;
                        }
                    }
                }
                case '2': 
                {
                    break;
                }
                case '3': 
                {
                    break;
                }
                case '4': //Tiradas
                {
                    switch (cadena.charAt(2)) {
                        case '1': //Solicitud
                        {
                            break;
                        }
                        case '2': //Envio
                        {
                            String tirada=(cadena.substring(3,cadena.length()));
                            break;
                        }
                    }
                    break;
                }    
            }
        }

    }
}
