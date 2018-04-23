package br.com.caelum.tarefas.modelo;

import java.util.Calendar;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 255, message = "Você deve escrever mais de 5 e menos de 255 caracteres")
	private String descricao;
	
	private boolean finalizado;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataFinalizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

}
