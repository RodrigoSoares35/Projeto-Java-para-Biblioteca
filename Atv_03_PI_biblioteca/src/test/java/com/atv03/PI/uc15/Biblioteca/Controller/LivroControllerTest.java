
package com.atv03.PI.uc15.Biblioteca.Controller;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Livro;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;


public class LivroControllerTest {
    
     Livro livro;
    
    @Before
    public void setUp() {
        livro = new Livro();
    }

    @Test
    public void LivroNulo() {
        System.out.println("Verificar se livro é nulo");
        Livro livro = null;
        assertNull(livro);
    }

    @Test
    public void LivroNaoENulo() {
        System.out.println("Verificar se livro não é nulo");
        assertNotNull(livro);
    }

    @Test
    public void NomeLivro() {
        System.out.println("Testar nome do livro");
        String nomeEsperado = "Dom Casmurro";
        livro.setNomeLivro(nomeEsperado);
        assertEquals(nomeEsperado, livro.getNomeLivro());
    }

    @Test
    public void Autor() {
        System.out.println("Testar  autor");
        String autorEsperado = "Machado de Assis";
        livro.setAutor(autorEsperado);
        assertEquals(autorEsperado, livro.getAutor());
    }

   @Test
public void Categoria() {
    System.out.println("categoria");
    String categoriaEsperada = "Romance";
    livro.setCategoria(categoriaEsperada);
    assertEquals(categoriaEsperada, livro.getCategoria());
}

}
