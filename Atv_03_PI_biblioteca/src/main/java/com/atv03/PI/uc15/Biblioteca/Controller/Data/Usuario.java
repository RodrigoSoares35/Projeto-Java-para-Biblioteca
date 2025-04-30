
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
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message="Nome obrigatório")
    private String nome;
    
    @NotBlank(message="Cpf obrigatório")
    private String cpf;
    
    @NotBlank(message="Telefone obrigatório")
    private String telefone;
    
    @NotBlank(message="Endereço obrigatório")
    private String endereco;
    
    @NotBlank(message="Data Nasc. obrigatório")
    private String dataNascimento;
}
