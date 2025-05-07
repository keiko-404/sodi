package pe.edu.utp.isi.dwi.sodi.sodi.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "aplicacion")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aplicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_aplicacion")
    private int codAplicacion;

    @ManyToOne
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;

    @JoinColumn(name = "nombre_aplicacion")
    private String nombreAplic;

    @JoinColumn(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "aplicacion", cascade = CascadeType.ALL)
    private List<Solicitud> solicitudes;

    public Aplicacion(int codAplicacion) {
        this.codAplicacion = codAplicacion;
    }
}
