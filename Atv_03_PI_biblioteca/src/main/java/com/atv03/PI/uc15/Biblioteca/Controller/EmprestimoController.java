
package com.atv03.PI.uc15.Biblioteca.Controller;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Emprestimo;
import com.atv03.PI.uc15.Biblioteca.Service.EmprestimoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    
    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllEmprestimo() {

        List<Emprestimo> emprestimo = emprestimoService.listarTodosEmprestimo();

        return new ResponseEntity<>(emprestimo, HttpStatus.OK);

    }
     @GetMapping("/pesquisar/{id}")

    public ResponseEntity<Emprestimo> getEmprestimoById(@PathVariable Integer id) {

        Emprestimo emprestimo = emprestimoService.getEmprestimoId(id);

        return new ResponseEntity<>(emprestimo, HttpStatus.OK);

    }

    @PostMapping("/adicionar")

    public ResponseEntity<Emprestimo> addEmprestimo(@Valid @RequestBody Emprestimo emprestimo) {

        var novoEmprestimo = emprestimoService.criarEmprestimo(emprestimo);

        return new ResponseEntity<>(novoEmprestimo, HttpStatus.CREATED);

    }

    @DeleteMapping("/deletar/{id}")

    public ResponseEntity deletarEmprestimo(@PathVariable Integer id) {

        emprestimoService.deletarEmprestimo(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
    
}
