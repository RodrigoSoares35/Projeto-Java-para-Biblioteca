
package com.atv03.PI.uc15.Biblioteca.Service;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Usuario;
import com.atv03.PI.uc15.Biblioteca.Controller.Data.UsuarioRepository;
import com.atv03.PI.uc15.Biblioteca.Exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setId(null);
        return usuarioRepository.save(usuario);
    
    }
    public Usuario atualizarUsuario(Integer usuarioId, Usuario usuarioRequest) {

        Usuario usuario = getUsuarioId(usuarioId);

        usuario.setNome(usuarioRequest.getNome());

        usuario.setCpf(usuarioRequest.getCpf());

        usuario.setTelefone(usuarioRequest.getTelefone());

        usuario.setEndereco(usuarioRequest.getEndereco());
        
        usuario.setDataNascimento(usuarioRequest.getDataNascimento());
        
        return usuarioRepository.save(usuario);

    }
      public List<Usuario> listarTodosUsuario() {
    return usuarioRepository.findAll();

    }
      public Usuario getUsuarioId(Integer usuarioId) {

     return usuarioRepository.findById(usuarioId).orElseThrow(()
     -> new ResourceNotFoundException("Usuario não encontrado " + usuarioId));

    }
       public void deletarUsuario(Integer usuarioId) {

        Usuario usuario = getUsuarioId(usuarioId);

        usuarioRepository.deleteById(usuario.getId());

    }

    public List<Usuario> getTodosUsuario() {
        return usuarioRepository.findAll();
    }
}
