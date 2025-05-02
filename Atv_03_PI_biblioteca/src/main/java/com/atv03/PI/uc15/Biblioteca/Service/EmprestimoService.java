
package com.atv03.PI.uc15.Biblioteca.Service;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Emprestimo;
import com.atv03.PI.uc15.Biblioteca.Controller.Data.EmprestimoRepository;
import com.atv03.PI.uc15.Biblioteca.Exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {
     @Autowired
    private EmprestimoRepository emprestimoRepository;

    public Emprestimo criarEmprestimo(Emprestimo emprestimo) {
        emprestimo.setId(null);
        return emprestimoRepository.save(emprestimo);
    
    }
    
    public Emprestimo atualizarEmprestimo(Integer emprestimoId, Emprestimo emprestimoRequest) {

        Emprestimo emprestimo = getEmprestimoId(emprestimoId);

        emprestimo.setIdUsuario(emprestimoRequest.getIdUsuario());

        emprestimo.setNomeUsuario(emprestimoRequest.getNomeUsuario());

        emprestimo.setTitulo(emprestimoRequest.getTitulo());

        emprestimo.setDataEmprestimo(emprestimoRequest.getDataEmprestimo());
        
        emprestimo.setDataEntrega(emprestimoRequest.getDataEntrega());
        
        return emprestimoRepository.save(emprestimo);

    }
      public List<Emprestimo> listarTodosEmprestimo() {
    return emprestimoRepository.findAll();

    }
      public Emprestimo getEmprestimoId(Integer emprestimoId) {

     return emprestimoRepository.findById(emprestimoId).orElseThrow(()
     -> new ResourceNotFoundException("Emprestimo não encontrado " + emprestimoId));

    }
       public void deletarEmprestimo(Integer emprestimoId) {

        Emprestimo emprestimo = getEmprestimoId(emprestimoId);

        emprestimoRepository.deleteById(emprestimo.getId());

    }

    public List<Emprestimo> getTodosEmprestimo() {
        return emprestimoRepository.findAll();
    }
}
