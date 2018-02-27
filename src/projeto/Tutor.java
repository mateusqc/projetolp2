package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tutor implements Comparable<Tutor>{
	/**
	 * Objeto Aluno ao qual o Tutor se refere.
	 */
	private Aluno aluno;
	/**
	 * Mapa de Disciplinas do Tutor, onde a chave é o nome da disciplina e 
	 * o valor é a proficiência do tutor na dada disciplina.
	 */
	private Map<String, Integer> disciplinas;
	/**
	 * Dinheiro recebido pelo Tutor.
	 */
	private double dinheiro;
	/**
	 * Lista de notas de avaliação do Tutor.
	 */
	private List<Double> notaAvaliacaoTutor;
	
	/**
	 * Construtor de Tutor, inicializa os argumentos da classe.
	 * @param disciplina nome da primeira disciplina do Tutor
	 * @param proficiencia proficiência da primeira disciplina
	 * @param aluno referência ao objeto aluno que se tornou Tutor
	 */
	public Tutor(String disciplina, int proficiencia, Aluno aluno) {
		this.disciplinas = new HashMap<String, Integer>();
		this.disciplinas.put(disciplina, proficiencia);
		this.aluno = aluno;
		this.dinheiro = 0;
		this.notaAvaliacaoTutor = new ArrayList<Double>();
		this.notaAvaliacaoTutor.add(4.0);
	}
	
	/**
	 * Método que adiciona mais uma disciplina de tutoria ao Tutor.
	 * @param disciplina nome da disciplina
	 * @param proficiencia valor de proficiência do Tutor
	 */
	public void adicionarDisciplina(String disciplina, int proficiencia) {
		if (this.disciplinas.containsKey(disciplina)) {
			throw new IllegalArgumentException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
		}
		this.disciplinas.put(disciplina, proficiencia);
	}
	
	/**
	 * Método que calcula a média das avaliações do Tutor.
	 * @return double com o valor da média
	 */
	private double calcularMediaAvaliacao() {
		double soma = 0;
		for (double nota : this.notaAvaliacaoTutor) {
			soma += nota;
		}
		return soma/this.notaAvaliacaoTutor.size();
	}
	
	public double pegarNota() {
		return this.calcularMediaAvaliacao();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutor other = (Tutor) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.aluno.toString();
		
	}

	public int compareTo(Tutor o) {
		return this.aluno.compareTo(o.aluno);
	}
	
}