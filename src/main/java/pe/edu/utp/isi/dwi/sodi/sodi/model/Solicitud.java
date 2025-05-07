package pe.edu.utp.isi.dwi.sodi.sodi.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "solicitud")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_solicitud")
    private int codSolicitud;

    @ManyToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cod_aplicacion")
    private Aplicacion aplicacion;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "tipo_solicitud")
    private String tipoSolicitud; //Error de software, capacitación, tequerimiento

    @Column(name = "prioridad")
    private String prioridad; //Alto, medio, bajo

    @Column(name = "fecha_creacion")
    private String fechaCreacion;

    @Column(name = "estado")
    private String estado; //Pendiente, en progreso y finalizado

    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;

    public Solicitud(int codSolicitud) {
        this.codSolicitud = codSolicitud;
    }

}
