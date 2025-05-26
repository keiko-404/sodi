package pe.edu.utp.isi.dwi.sodi.sodi.model;

import java.util.ArrayList;
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
import jakarta.persistence.OneToOne;
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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usuario")
    private int codUsuario;

    @OneToOne
    @JoinColumn(name = "cod_cuenta")
    private Cuenta oCuenta;

    @ManyToOne
    @JoinColumn(name = "cod_cliente")
    private Cliente oCliente;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Builder.Default
    @OneToMany(mappedBy = "oUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Solicitud> lSolicitudes = new ArrayList<>();

    public Usuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

}
