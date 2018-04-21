package br.com.caelum.tarefas.controller;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TarefasController {
	
	@RequestMapping("/formularioTarefa")
	public String formulario() {
		return "tarefas/formulario-tarefa";
	}
	
	@RequestMapping("/adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		
		if(result.hasFieldErrors()) {
			return "tarefas/formulario-tarefa";
		}
		
		JdbcTarefaDao tarefaDao = new JdbcTarefaDao();
		tarefaDao.adiciona(tarefa);
		
		return "redirect:/lista";
	}
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		JdbcTarefaDao tarefaDao = new JdbcTarefaDao();
		List<Tarefa> listaTarefa = tarefaDao.lista();
		model.addAttribute("lista", listaTarefa);
		
		return "tarefas/lista-tarefas";
	}
	
	@RequestMapping("/remove")
	public String remove(Tarefa tarefa) {
		JdbcTarefaDao tarefaDao = new JdbcTarefaDao();
		tarefaDao.remove(tarefa);
		
		return "redirect:/lista";
	}
	
	@RequestMapping("/mostraTarefa")
	public String mostrar(Tarefa tarefa, Model model) {
		JdbcTarefaDao tarefaDao = new JdbcTarefaDao();
		Tarefa tarefaBanco = tarefaDao.buscaPorId(tarefa.getId());
		model.addAttribute("tarefa", tarefaBanco);
		
		return "tarefas/formulario-alteracao";
	}
	
	@RequestMapping("/altera")
	public String altera(Tarefa tarefa) {
		JdbcTarefaDao tarefaDao = new JdbcTarefaDao();
		tarefaDao.altera(tarefa);
		
		return "redirect:/lista";
	}

	
}	
