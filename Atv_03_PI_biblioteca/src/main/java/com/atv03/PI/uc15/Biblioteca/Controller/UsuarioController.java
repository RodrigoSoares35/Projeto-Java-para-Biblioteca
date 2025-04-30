
package com.atv03.PI.uc15.Biblioteca.Controller;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Usuario;
import com.atv03.PI.uc15.Biblioteca.Service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {
    
     @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllUsuario() {

        List<Usuario> usuario = usuarioService.listarTodosUsuario();

        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }
    @GetMapping("/pesquisarUsuario/{id}")

    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {

        Usuario usuario = usuarioService.getUsuarioId(id);

        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }
    @PostMapping("/adicionar")

    public ResponseEntity<Usuario> addUsuario(@Valid @RequestBody Usuario usuario) {

        var novoUsuario = usuarioService.criarUsuario(usuario);

        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);

    }

    @DeleteMapping("/deletar/{id}")

    public ResponseEntity deletarUsuario(@PathVariable Integer id) {

        usuarioService.deletarUsuario(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
