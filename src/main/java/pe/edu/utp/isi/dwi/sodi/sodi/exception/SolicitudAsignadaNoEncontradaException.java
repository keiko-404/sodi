package pe.edu.utp.isi.dwi.sodi.sodi.exception;

/**
 *
 * @author #RoaAlyc '^'
 */
public class SolicitudAsignadaNoEncontradaException extends RuntimeException {
    
    public SolicitudAsignadaNoEncontradaException (int codSolicitud) {
        
        super("La solicitud " + codSolicitud + " asignada no es encontro o no existe");
    }
}
