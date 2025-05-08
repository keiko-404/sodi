package pe.edu.utp.isi.dwi.sodi.sodi.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cliente")
    private int codCliente;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "tipo_cliente")
    private String tipoCliente; //empresa o persona natural

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;
    
    @Builder.Default
    @OneToMany(mappedBy = "oCliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aplicacion> lAplicaciones = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "oCliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuario> lUsuarios = new ArrayList<>();

    public Cliente(int codCliente) {
        this.codCliente = codCliente;
    }

}
