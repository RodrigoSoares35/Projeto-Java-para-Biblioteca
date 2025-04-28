
package com.atv03.PI.uc15.Biblioteca.Service;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Livro;
import com.atv03.PI.uc15.Biblioteca.Controller.Data.LivroRepository;
import com.atv03.PI.uc15.Biblioteca.Exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;

    public Livro criarLivro(Livro livro) {
        livro.setId(null);
        return livroRepository.save(livro);
    
    }
     public Livro atualizarLivro(Integer livroId, Livro livroRequest) {

        Livro livro = getLivroId(livroId);

        livro.setNomeLivro(livroRequest.getNomeLivro());

        livro.setAutor(livroRequest.getAutor());

        livro.setQuantidade(livroRequest.getQuantidade());

        livro.setCategoria(livroRequest.getCategoria());
        
        livro.setLocalizacao(livroRequest.getLocalizacao());
        
        return livroRepository.save(livro);

    }
      public List<Livro> listarTodosLivro() {
    return livroRepository.findAll();

    }
      public Livro getLivroId(Integer livroId) {

     return livroRepository.findById(livroId).orElseThrow(()
     -> new ResourceNotFoundException("livro não encontrado " + livroId));

    }
       public void deletarLivro(Integer livroId) {

        Livro livro = getLivroId(livroId);

        livroRepository.deleteById(livro.getId());

    }

    public List<Livro> getTodosLivro() {
        return livroRepository.findAll();
    }
}
