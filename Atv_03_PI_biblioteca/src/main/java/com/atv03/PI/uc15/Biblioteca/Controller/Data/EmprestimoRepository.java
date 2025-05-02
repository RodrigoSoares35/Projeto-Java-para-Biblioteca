
package com.atv03.PI.uc15.Biblioteca.Controller.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository  extends JpaRepository<Emprestimo,Integer>{
    
}
