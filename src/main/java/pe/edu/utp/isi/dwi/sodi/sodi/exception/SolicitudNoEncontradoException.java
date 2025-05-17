package pe.edu.utp.isi.dwi.sodi.sodi.exception;

/**
 *
 * @author #RoaAlyc '^'
 */
public class SolicitudNoEncontradoException extends RuntimeException{
    
    public SolicitudNoEncontradoException (int codSolicitud) {
        
        super("La solicitud " + codSolicitud + " no se encontro o no existe");
    }
}
