
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
@Table(name="emprestimo")
public class Emprestimo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    private Integer idUsuario;
    
    @NotBlank(message="Nome obrigatório")
    private String nomeUsuario;
    
    @NotBlank(message="Titulo obrigatório")
    private String titulo;
    
    @NotBlank(message="Data obrigatória")
    private String dataEmprestimo;
    
    private String dataEntrega;
}
