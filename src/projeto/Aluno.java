package projeto;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Aluno no sistema QUEM ME AJUDA.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 */
public class Aluno implements Comparable<Aluno>{

	/**
	 * Matrícula do Aluno.
	 */
	private String matricula;
	/**
	 * Nome do Aluno.
	 */
	private String nome;
	/**
	 * Código do curso do Aluno.
	 */
	private int codigoCurso;
	/**
	 * Telefone do Aluno - Atributo opicional.
	 */
	private String telefone;
	/**
	 * E-mail do Aluno.
	 */
	private String email;
	/**
	 * Lista de notas de avaliação do Aluno.
	 */
	private List<Double> notaAvaliacao;
	
	/**
	 * Construtor de Aluno. Caso o telefone informado seja vazio ou nulo, será amazenado vazio.
	 * O valor inicial da média é 5, por isso foi adicionado um único valor ao Array de notas. 
	 * @param nome nome do aluno
	 * @param matricula matrícula do aluno
	 * @param codigoCurso código do curso
	 * @param telefone telefone do aluno
	 * @param email e-mail do aluno
	 */
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.verificaDados(nome, email);
		
		this.matricula = matricula;
		this.nome = nome;
		this.codigoCurso = codigoCurso;
		if(telefone == null || telefone.trim().equals("")) {
			this.telefone = "";
		}else {
			this.telefone = telefone;
		}
		this.email = email;
		this.notaAvaliacao = new ArrayList<Double>();
		this.notaAvaliacao.add(5.0);
	}
	
	/**
	 * Método que verifica a validade das Strings de nome e e-mail.
	 * @param nome nome do aluno
	 * @param email email do aluno
	 */
	private void verificaDados(String nome, String email) {
		if(nome == null) {
			throw new NullPointerException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		if(nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		if(!email.contains("@")) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}
		
		String[] emailParcionado = email.split("@");
		
		if (emailParcionado.length != 2) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}
		
		for(int i = 0; i < emailParcionado.length; i++) {
			if(emailParcionado[i].equals("")) {
				throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
			}
		}
	}
	
	/**
	 * Método que calcula a média das avaliações do Aluno.
	 * @return double com o valor da média
	 */
	private double calculaMediaAvaliacao() {
		double soma = 0;
		for (double nota : this.notaAvaliacao) {
			soma += nota;
		}
		return soma/this.notaAvaliacao.size();
	}
	
	/**
	 * Método que retorna o atributo Nome do Aluno.
	 * @return String com o nome do aluno
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Método que retorna o atributo E-mail do Aluno.
	 * @return String com o e-mail do aluno
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Método que retorna o atributo Telefone do Aluno.
	 * @return String com o telefone do aluno
	 */
	public String getTelefone() {
		return this.telefone;
	}
	
	/**
	 * Retorna o valor da média das avaliações do Aluno.
	 * @return double com o valor da média
	 */
	public double getNotaAvaliacao() {
		return this.calculaMediaAvaliacao();
	}
	
	/**
	 * Método que retorna uma representação em String das informações do Aluno, seguindo o seguinte padrão: 
	 * matricula - nome - codigoCurso - telefone (caso tenha sido informado) - email
	 * @return String com as informações do Aluno
	 */
	@Override
	public String toString() {
		if(telefone == "") {
			return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email;
		}
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " +  this.telefone + " - " + this.email;

	}
	
	/**
	 * Método hashCode que tem como como base de cálculo o atributo matricula.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Método equals que tem como base de comparação o atributo matricula.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Método compareTo implementado da interface {@link Comparable}. A ordenação natural definida para Aluno foi a de ordem
	 * alfabética por nome.
	 */
	public int compareTo(Aluno a) {
		return this.nome.compareTo(a.nome);
	}

		
}
