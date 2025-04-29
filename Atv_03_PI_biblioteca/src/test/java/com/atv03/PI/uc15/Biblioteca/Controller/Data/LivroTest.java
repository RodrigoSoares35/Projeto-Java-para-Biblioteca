
package com.atv03.PI.uc15.Biblioteca.Controller.Data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LivroTest {
    
   private Livro livro;

    @Before
    public void setUp() {
        livro = new Livro();
    }

    @Test
    public void ValidacaoId() {
        Integer id = 1;
        livro.setId(id);
        assertEquals(id, livro.getId());
    }

    @Test
    public void validacaoNomeLivro() {
        String nome = "Dom Casmurro";
        livro.setNomeLivro(nome);
        assertEquals(nome, livro.getNomeLivro());
    }

    @Test
    public void validacaoAutor() {
        String autor = "Machado de Assis";
        livro.setAutor(autor);
        assertEquals(autor, livro.getAutor());
    }

    @Test
    public void validacaoCategoria() {
        String categoria = "Romance";
        livro.setCategoria(categoria);
        assertEquals(categoria, livro.getCategoria());
    }

    @Test
    public void validacaoQuantidade() {
        Integer quantidade = 10;
        livro.setQuantidade(quantidade);
        assertEquals(quantidade, livro.getQuantidade());
    }
    

    @Test
    public void validacaoLocalizacao() {
        String localizacao = "Estante A3";
        livro.setLocalizacao(localizacao);
        assertEquals(localizacao, livro.getLocalizacao());
    }

    @Test
    public void IgualdadeLivro() {
        Livro livro2 = new Livro();
        livro.setId(1);
        livro2.setId(1);
        assertTrue(livro.equals(livro2));
        assertEquals(livro.hashCode(), livro2.hashCode());
    }

    @Test
    public void DiferencaLivro() {
        Livro livro2 = new Livro();
        livro.setId(1);
        livro2.setId(2);
        assertFalse(livro.equals(livro2));
    }

    @Test
    public void testCanEqual() {
        assertTrue(livro.canEqual(new Livro()));
        assertFalse(livro.canEqual(new Object()));
    }

    @Test
    public void testToString() {
        livro.setId(1);
        livro.setNomeLivro("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setCategoria("Romance");
        livro.setQuantidade(10);
        livro.setLocalizacao("Estante A3");

        String result = livro.toString();

        assertTrue(result.contains("Dom Casmurro"));
        assertTrue(result.contains("Machado de Assis"));
        assertTrue(result.contains("Romance"));
        assertTrue(result.contains("Estante A3"));
        assertTrue(result.contains("10"));
    }
}
