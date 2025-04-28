
package com.atv03.PI.uc15.Biblioteca.Controller;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Livro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


public class LvrControllerTest {
    private LvrController instance;

    @Before
    public void setUp() {
        instance = new LvrController();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void ListaLivro() {
        System.out.println("listaLivro");
        Model model = Mockito.mock(Model.class);
        String result = instance.listaLivro(model);
        assertEquals("listaLivros", result);
    }

    @Test
    public void DeletarLivro() {
        System.out.println("deletarLivro");
        Integer id = 1;
        String result = instance.deletarLivro(id);
        assertEquals("redirect:/livros", result);
    }

    @Test
    public void MostrarFormularioCadastro() {
        System.out.println("mostrarFormularioCadastro");
        Model model = Mockito.mock(Model.class);
        String result = instance.mostrarFormularioCadastro(model);
        assertEquals("cadastroLivro", result);
    }

    @Test
    public void SalvarLivro() {
        System.out.println("salvarLivro");
        Livro livro = new Livro();
        BindingResult resultBinding = Mockito.mock(BindingResult.class);
        Mockito.when(resultBinding.hasErrors()).thenReturn(false);

        String result = instance.salvarLivro(livro, resultBinding);
        assertEquals("redirect:/livros", result);
    }

    @Test
    public void CriarLivroForm() {
        System.out.println("criarLivroForm");
        Model model = Mockito.mock(Model.class);
        String result = instance.criarLivroForm(model);
        assertEquals("formLivro", result);
    }

    @Test
    public void AtualizarLivroForm() {
        System.out.println("atualizarLivroForm");
        Integer id = 1;
        Model model = Mockito.mock(Model.class);
        String result = instance.atualizarLivroForm(id, model);
        assertEquals("formLivro", result);
    }

    @Test
    public void PesquisarLivro() {
        System.out.println("pesquisarLivro");
        Integer id = 1;
        Model model = Mockito.mock(Model.class);
        String result = instance.pesquisarLivro(id, model);
        assertEquals("detalhesLivro", result);
    } 
}
