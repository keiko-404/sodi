package pe.edu.utp.isi.dwi.sodi.sodi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_solicitud")
    private int codSolicitud;

    @ManyToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario oUsuario;

    @ManyToOne
    @JoinColumn(name = "cod_aplicacion")
    private Aplicacion oAplicacion;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "tipo_solicitud")
    private String tipoSolicitud; //Error de software, capacitación, tequerimiento

    @Column(name = "prioridad")
    private String prioridad; //Alto, medio, bajo

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "estado")
    private String estado; //Pendiente, en progreso y finalizado

    @Builder.Default
    @OneToMany(mappedBy = "oSolicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asignacion> lAsignaciones = new ArrayList<>();

    public Solicitud(int codSolicitud) {
        this.codSolicitud = codSolicitud;
    }

}
