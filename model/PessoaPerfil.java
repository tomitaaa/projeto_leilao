import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Target;
import lombok.Data;  
package com.github.tomitaaa.backend.model;



@Entity
@Target("PessoaPerfil")
@Data
public class PessoaPerfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    @JsonIgnore
    private Pessoa pessoa;

}
