/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import modelo.Modelo;
import vistas.Ventana;


/**
 *
 * @author nacho
 */
public class Master extends Jugador{
    
    public Master(Modelo modelo) {
        super(modelo);
    }

    public String getPublicIP() {
        return modelo.getPublicIP();
    }

    public void AbrirServidor(Ventana ventana) {
        modelo.abrirServidor();
        ventana.CambiarVentana("Ventana Master");
    }
    
    
    
}
