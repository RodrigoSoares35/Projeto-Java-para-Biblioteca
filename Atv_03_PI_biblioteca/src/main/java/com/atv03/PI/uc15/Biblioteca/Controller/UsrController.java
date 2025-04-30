
package com.atv03.PI.uc15.Biblioteca.Controller;

import com.atv03.PI.uc15.Biblioteca.Controller.Data.Usuario;
import com.atv03.PI.uc15.Biblioteca.Service.UsuarioService;
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
public class UsrController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listaUsuario")
    public String listaUsuario(Model model) {
        model.addAttribute("listarUsuario", usuarioService.listarTodosUsuario());
        return "listaUsuario";
    }
    
     @GetMapping("/deletarUsuario/{id}")
    public String deletarUsuario(@PathVariable(value = "id") Integer id) {
        usuarioService.deletarUsuario(id);
        return "redirect:/listaUsuario";
    }

    @GetMapping("/cadastrarUsuario")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastrarUsuario";
    }
    
    @PostMapping("/salvarUsuario")
    public String salvarSalvar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
        System.out.println("Recebido: " + usuario);

        if (result.hasErrors()) {
            return "cadastrarUsuario";
        }

        if (usuario.getId() == null) {
            usuarioService.criarUsuario(usuario);
        } else {
            usuarioService.atualizarUsuario(usuario.getId(), usuario);
        }
        return "redirect:/listaUsuario";

    }

    @GetMapping("/criarUsuarioForm")
    public String criarUsuarioForm(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "cadastrarUsuario";
    }

    @GetMapping("/atualizarUsuarioForm/{id}")
    public String atualizarUsuarioForm(@PathVariable(value = "id") Integer id, Model model) {
        Usuario usuario = usuarioService.getUsuarioId(id);
        model.addAttribute("usuario", usuario);
        return "atualizarUsuario";
    }

   @GetMapping("/pesquisarUsuario")
    public String pesquisarUsuario(@RequestParam("id") Integer id, Model model) {
    Usuario usuario = usuarioService.getUsuarioId(id);
    model.addAttribute("usuario", usuario);
    return "/listaUsuario"; 
}

}
