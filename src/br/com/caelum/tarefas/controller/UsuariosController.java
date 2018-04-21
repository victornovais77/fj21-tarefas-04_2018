package br.com.caelum.tarefas.controller;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuariosController {
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "usuarios/loginForm";
	}
	
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if(new JdbcUsuarioDao().existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:/lista";
		}
		
		return "redirect:/loginForm?error=Login ou senha invalidos";
	}
	
}





