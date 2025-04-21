/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.isi.dwi.sodi.sodi.dto;

import pe.edu.utp.isi.dwi.sodi.sodi.model.Solicitud;

/**
 *
 * @author #RoaAlyc '^'
 */
public class SolicitudMapper {
    
    // devulve aDOT, lleva a producto que especifica
    public static SolicitudDTO toDTO(Solicitud solicitud) {
        return new SolicitudDTO
        (
                solicitud.getCodigo(),
                solicitud.getTipo(),
                solicitud.getMotivo(),
                solicitud.getFecha()
        );
    }
    
}
// Entonces, transformo el producto que me dan, saco sus datos y los encapsulo en DTO