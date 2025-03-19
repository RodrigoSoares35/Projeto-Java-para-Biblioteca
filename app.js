
function telaMenu() {
    window.location.href = "menu.html";
   
}
// Validação de Usuário e senha
const USUARIO_CORRETO = "Admin";
const SENHA_CORRETA = "Admin";

function validarLogin() {
    let usuarioDigitado = document.getElementById("usuario").value.trim();
    let senhaDigitada = document.getElementById("senha").value.trim();
   
    // Verifica se os campos estão preenchidos
    if (usuarioDigitado === "" || senhaDigitada === "") {
        alert("Preencha todos os campos!");
        return false;
    }

    // Verifica se o usuário e a senha estão corretos 
    if (usuarioDigitado === USUARIO_CORRETO && senhaDigitada === SENHA_CORRETA) {
        alert("Login efetuado com sucesso!");
        telaMenu(); // Certifique-se de que a função telaMenu está definida em algum lugar
        return true;
    } else {
        alert("Usuário ou senha incorretos!");
        console.log("Usuário digitado:", usuarioDigitado, "Usuário correto:", USUARIO_CORRETO);
        console.log("Senha digitada:", senhaDigitada, "Senha correta:", SENHA_CORRETA);
        return false;
    }
}

// Função chamada ao clicar no botão de login
function fazerLogin(event) {
    if (!validarLogin()) {
        event.preventDefault(); 
    }
}
