
package com.atv03.PI.uc15.Biblioteca.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {
    
    @GetMapping("/")
    public String login(Model model) {
        return "index";
    }
    @GetMapping("menu")
    public String menu(Model model) {
        return "menu";
    }
    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String pswd, Model model) {
        // Defina seu usuário e senha aqui ou recupere de uma base de dados
        String usuarioCorreto = "Admin";
        String senhaCorreta = "Admin";

        // Validação do usuário e senha
        if (usuarioCorreto.equals(usuario) && senhaCorreta.equals(pswd)) {
            return "redirect:/menu"; // Redireciona para a página do menu
        } else {
            model.addAttribute("error", "Usuário ou senha incorretos!");
            return "login"; // Retorna para o formulário de login com uma mensagem de erro
        }
    }

}
