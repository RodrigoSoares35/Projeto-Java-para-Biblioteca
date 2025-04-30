package com.atv03.PI.uc15.Biblioteca.Controller;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Livro;
import com.atv03.PI.uc15.Biblioteca.Service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LvrController {

    @Autowired
    LivroService livroService;

    @GetMapping("/listaLivro")
    public String listaLivro(Model model) {
        model.addAttribute("listarLivro", livroService.listarTodosLivro());
        return "listaLivro";
    }

    @GetMapping("/deletarLivro/{id}")
    public String deletarLivro(@PathVariable(value = "id") Integer id) {
        livroService.deletarLivro(id);
        return "redirect:/listaLivro";
    }

    @GetMapping("/cadastrarLivro")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("livro", new Livro());
        return "cadastrarLivro";
    }

    @PostMapping("/salvarLivro")
    public String salvarLivro(@Valid @ModelAttribute("livro") Livro livro, BindingResult result) {
        System.out.println("Recebido: " + livro);

        if (result.hasErrors()) {
            return "cadastrarLivro";
        }

        if (livro.getId() == null) {
            livroService.criarLivro(livro);
        } else {
            livroService.atualizarLivro(livro.getId(), livro);
        }
        return "redirect:/listaLivro";

    }

    @GetMapping("/criarLivroForm")
    public String criarLivroForm(Model model) {
        Livro livro = new Livro();
        model.addAttribute("livro", livro);
        return "cadastrarLivro";
    }

    @GetMapping("/atualizarLivroForm/{id}")
    public String atualizarLivroForm(@PathVariable(value = "id") Integer id, Model model) {
        Livro livro = livroService.getLivroId(id);
        model.addAttribute("livro", livro);
        return "atualizarLivro";
    }

   @GetMapping("/pesquisar")
public String pesquisarLivro(@RequestParam("id") Integer id, Model model) {
    Livro livro = livroService.getLivroId(id);
    model.addAttribute("livro", livro);
    return "/listaLivro"; 
}

}
