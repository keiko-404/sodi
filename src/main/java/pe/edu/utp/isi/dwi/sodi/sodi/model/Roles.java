package pe.edu.utp.isi.dwi.sodi.sodi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "roles")
public class Roles {
    
    @Id
    @Column(name = "cod_roles")
    private int codRoles;
    
    @Column(name = "rol")
    private String rol; // Admin, Colborador, Usuario

    public Roles(int codRoles) {
        this.codRoles = codRoles;
    }
    
}
