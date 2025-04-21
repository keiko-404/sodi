/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.isi.dwi.sodi.sodi.exception;

/**
 *
 * @author #RoaAlyc '^'
 */
public class SolicitudNoEncontradoException extends RuntimeException{
    
    public SolicitudNoEncontradoException (String codigo) {
        
        super("La solicitud '" + codigo + "' no se encontro o no existe.");
    } 
    
}
