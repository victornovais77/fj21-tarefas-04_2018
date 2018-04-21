package br.com.caelum.tarefas.controller;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class TarefasController {
	
	private JdbcTarefaDao tarefaDao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao tarefaDao) {
		this.tarefaDao = tarefaDao;
	}
	
	@RequestMapping("/formularioTarefa")
	public String formulario() {
		return "tarefas/formulario-tarefa";
	}
	
	@RequestMapping("/adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		
		if(result.hasFieldErrors()) {
			return "tarefas/formulario-tarefa";
		}
		
		tarefaDao.adiciona(tarefa);
		
		return "redirect:/lista";
	}
	
	@RequestMapping("/lista")
	public String lista(Model model, HttpSession session) {
		List<Tarefa> listaTarefa = tarefaDao.lista();
		model.addAttribute("lista", listaTarefa);
		
		return "tarefas/lista-tarefas";
	}
	
	@RequestMapping("/remove")
	public String remove(Tarefa tarefa) {
		tarefaDao.remove(tarefa);
		
		return "redirect:/lista";
	}
	
	@RequestMapping("/mostraTarefa")
	public String mostrar(Tarefa tarefa, Model model) {
		Tarefa tarefaBanco = tarefaDao.buscaPorId(tarefa.getId());
		model.addAttribute("tarefa", tarefaBanco);
		
		return "tarefas/formulario-alteracao";
	}
	
	@RequestMapping("/altera")
	public String altera(Tarefa tarefa) {
		tarefaDao.altera(tarefa);
		
		return "redirect:/lista";
	}

	@ResponseBody
	@RequestMapping("/finaliza")
	public void finaliza(Long id) {
		tarefaDao.finaliza(id);
	}

	
}	
