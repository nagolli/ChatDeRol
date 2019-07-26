/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import modelo.Modelo;
import vistas.*;

/**
 *
 * @author nacho
 */
public class Usuario {

    public Usuario() {
        this.modelo=new Modelo();
    }
    
    Modelo modelo;
    
    public Modelo getModelo() {
        return modelo;
    }
    
    public void MP_MasterearPartida(Ventana ventana)
    {
        ventana.CambiarVentana("Hostear Partida");
    }
    
    public void MP_JugarPartida(Ventana ventana)
    {
        ventana.CambiarVentana("Buscar Partida");
    }
    
    public void MP_Configuracion(Ventana ventana)
    {
        
    }
    
}