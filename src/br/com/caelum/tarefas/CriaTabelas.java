package br.com.caelum.tarefas;

import br.com.caelum.tarefas.modelo.Tarefa;
import java.util.List;
import javax.persistence.*;

public class CriaTabelas {
	
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Tarefa muito marota");
		tarefa.setFinalizado(false);


		List<Tarefa> tarefas = manager.createQuery("select t from Tarefa t where t.finalizado = :finalizado")
			.setParameter("finalizado", false)
			.getResultList();
		
		tarefas.forEach(t -> System.out.println(t.getDescricao()));

		// manager.getTransaction().begin();
		
		// Tarefa tarefaDoBanco = manager.find(Tarefa.class, 1L);
		// tarefaDoBanco.setDescricao("Descricao alterada legal!");
		// manager.merge(tarefaDoBanco);

		// manager.getTransaction().commit();
		
		manager.close();
		
	}
	
	
}
