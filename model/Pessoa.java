package com.github.tomitaaa.backend.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Data;


@Entity
@Data
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "{validation.name.notblank}")
    private String nome;
    @NotBlank(message = "{validation.email.notblank}")
    @Email(message = "{validation.email.notvalid}")
    private String email;
    @JsonIgnore
    private String senha;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, FETCH = FetchType.EAGER)
    @Setter(value = AcessLevel.NONE)
    private List<PessoaPerfil> pessoaPerfil;

    public void setPessoaPerfil(List<PessoaPerfil> pessoaPerfil){
        for (PessoaPerfil p : pessoaPerfil) {
            p.setPessoa(this);
        }
        this.pessoaPerfil = pessoaPerfil;
    }

}
