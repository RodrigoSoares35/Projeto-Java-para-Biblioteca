
package com.atv03.PI.uc15.Biblioteca.Controller.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="livro")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message="Nome obrigatório")
    private String nomeLivro;
    
    @NotBlank(message="Autor obrigatório")
    private String autor;
    
    @NotBlank(message="Categoria obrigatório")
    private String categoria;
    
    private Integer quantidade;
    
    @NotBlank(message="Localização obrigatória")
    private String localizacao;
    
    
}
