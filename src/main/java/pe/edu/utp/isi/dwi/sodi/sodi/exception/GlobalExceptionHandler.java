package pe.edu.utp.isi.dwi.sodi.sodi.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 *
 * @author #RoaAlyc '^'
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Map<String, Object>> handleSolicitudNoEncontrado(SolicitudNoEncontradoException ex) {

        Map<String, Object> errorBody = new HashMap<>();

        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("status", HttpStatus.NOT_FOUND.value());
        errorBody.put("error", "Solicitud no encontrado");
        errorBody.put("menssage", ex.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    // para la actividad, solicitud no ecnontrada por parte del colab
    public ResponseEntity<Map<String, Object>> handleSolicitudAsignadaNoEncontrada(SolicitudAsignadaNoEncontradaException ex) {

        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("status", HttpStatus.NOT_FOUND.value());
        errorBody.put("error", "Solicitud asignada no encontrado");
        errorBody.put("menssage", ex.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

}


