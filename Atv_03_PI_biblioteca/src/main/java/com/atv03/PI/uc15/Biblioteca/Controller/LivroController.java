package com.atv03.PI.uc15.Biblioteca.Controller;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Livro;
import com.atv03.PI.uc15.Biblioteca.Service.LivroService;
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
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllLivro() {

        List<Livro> livro = livroService.listarTodosLivro();

        return new ResponseEntity<>(livro, HttpStatus.OK);

    }

    @GetMapping("/pesquisar/{id}")

    public ResponseEntity<Livro> getLivroById(@PathVariable Integer id) {

        Livro livro = livroService.getLivroId(id);

        return new ResponseEntity<>(livro, HttpStatus.OK);

    }

    @PostMapping("/adicionar")

    public ResponseEntity<Livro> addLivro(@Valid @RequestBody Livro livro) {

        var novoLivro = livroService.criarLivro(livro);

        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);

    }

    @DeleteMapping("/deletar/{id}")

    public ResponseEntity deletarLivro(@PathVariable Integer id) {

        livroService.deletarLivro(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
