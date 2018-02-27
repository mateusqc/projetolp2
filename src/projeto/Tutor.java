package projeto;

import java.util.HashMap;
import java.util.Map;

public class Tutor implements Comparable<Tutor>{

	private Aluno aluno;
	private Map<String, Integer> disciplinas;
	private int proficiencia;
	private double dinheiro;
	private double[] notaAvaliacaoTutor;
	
	public Tutor(String disciplina, int proficiencia, Aluno aluno) {
		this.disciplinas = new HashMap<String, Integer>();
		this.disciplinas.put(disciplina, proficiencia);
		this.proficiencia = proficiencia;
		this.aluno = aluno;
		this.dinheiro = 0;
		this.notaAvaliacaoTutor = new double[] {4.0};
	}
	
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
		for (int i = 0; i < this.notaAvaliacaoTutor.length; i++) {
			soma += this.notaAvaliacaoTutor[i];
		}
		return soma/this.notaAvaliacaoTutor.length;
	}
	
	public double pegarNota() {
		return this.calcularMediaAvaliacao();
	}

	public int getProficiencia() {
		return proficiencia;
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