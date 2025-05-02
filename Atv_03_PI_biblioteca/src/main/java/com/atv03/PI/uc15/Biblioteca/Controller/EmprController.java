
package com.atv03.PI.uc15.Biblioteca.Controller;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Emprestimo;
import com.atv03.PI.uc15.Biblioteca.Service.EmprestimoService;
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
public class EmprController {
    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping("/listaEmprestimo")
    public String listaEmprestimo(Model model) {
        model.addAttribute("listarEmprestimo", emprestimoService.listarTodosEmprestimo());
        return "listaEmprestimo";
    }
    
     @GetMapping("/deletarEmprestimo/{id}")
    public String deletarEmprestimo(@PathVariable(value = "id") Integer id) {
        emprestimoService.deletarEmprestimo(id);
        return "redirect:/listaEmprestimo";
    }

    @GetMapping("/cadastrarEmprestimo")
    public String mostrarFormularioEmprestimo(Model model) {
        model.addAttribute("emprestimo", new Emprestimo());
        return "cadastrarEmprestimo";
    }
    
    @PostMapping("/salvarEmprestimo")
    public String salvarEmprestimo(@Valid @ModelAttribute("emprestimo") Emprestimo emprestimo, BindingResult result) {
        System.out.println("Recebido: " + emprestimo);

        if (result.hasErrors()) {
            return "cadastrarEmprestimo";
        }

        if (emprestimo.getId() == null) {
            emprestimoService.criarEmprestimo(emprestimo);
        } else {
            emprestimoService.atualizarEmprestimo(emprestimo.getId(), emprestimo);
        }
        return "redirect:/listaEmprestimo";

    }

    @GetMapping("/criarEmprestimoForm")
    public String criarEmprestimoForm(Model model) {
        Emprestimo emprestimo = new Emprestimo();
        model.addAttribute("emprestimo", emprestimo);
        return "cadastrarEmprestimo";
    }

    @GetMapping("/atualizarEmprestimoForm/{id}")
    public String atualizarEmprestimoForm(@PathVariable(value = "id") Integer id, Model model) {
        Emprestimo emprestimo = emprestimoService.getEmprestimoId(id);
        model.addAttribute("emprestimo", emprestimo);
        return "atualizarEmprestimo";
    }

   @GetMapping("/pesquisarEmprestimo")
public String pesquisarEmprestimo(@RequestParam("id") Integer id, Model model) {
    Emprestimo emprestimo = emprestimoService.getEmprestimoId(id);
    model.addAttribute("emprestimo", emprestimo);
    return "/listaEmprestimo"; 
}


}
