package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * Lista de locais cadastrados de um tutor.
	 */
	private List<String> locais;
	/**
	 * Lista de dias e horários cadastrados de um tutor.
	 */
	private Map<String, List<String>> horariosDeAtendimento;
	
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
		this.locais = new ArrayList<String>();
		this.horariosDeAtendimento =  new HashMap<String, List<String>>();
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
	
	/**
	 * Método que retorna a média de avaliações do Tutor.
	 * @return Double com a média de avaliações do Tutor.
	 */
	public double pegarNota() {
		return this.calcularMediaAvaliacao();
	}
	/**
	 * Método que adiciona um horario e/ou um dia na lista de horarios de atendimento de um tutor.
	 * @param horario horário disponível do atendimento
	 * @param dia dia disponível para atendimento
	 */
	public void cadastrarHorario(String horario, String dia) {
		if (this.horariosDeAtendimento.containsKey(dia)) {
			this.horariosDeAtendimento.get(dia).add(horario);
		} else {
			this.horariosDeAtendimento.put(dia, new ArrayList<String>());
			this.horariosDeAtendimento.get(dia).add(horario);
		}
	}
	
	/**
	 * Método que adiciona um local de atendimento na lista de locais de um tutor.
	 * @param local local disponível para atendimento
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		this.locais.add(local);
	}
	
	/**
	 * Método que verificia a disponibilidade de atendimento do tutor no horário e dia especificado.
	 * @param horario horário de atendimento
	 * @param dia dia de atendimento
	 * @return Boolean representando a disponibilidade (true para disponível, false para indisponível) 
	 */
	public boolean consultaHorario(String horario, String dia) {
		if (this.horariosDeAtendimento.containsKey(dia)) {
			if (this.horariosDeAtendimento.get(dia).contains(horario)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que verificia a disponibilidade de atendimento do tutor no local especificado.
	 * @param local local de atendimento
	 * @return Boolean representando a disponibilidade (true para disponível, false para indisponível) 
	 */
	public boolean consultaLocal(String local) {
		if (this.locais.contains(local)) {
			return true;
		}
		return false;
	}

	/**
	 * Método hashCode com cálculo baseado no atributo que armazena um objeto aluno, ou seja, {@link #aluno}.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		return result;
	}

	/**
	 * Método equals com comparação baseada no atributo que armazena um objeto aluno, ou seja, {@link #aluno}.
	 */
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
	
	/**
	 * Método que gera a representação em String de um tutor. Utiliza o método {@link Aluno#toString()} do atributo {@link #aluno}. 
	 */
	@Override
	public String toString() {
		return this.aluno.toString();
		
	}

	/**
	 * Método que compara dois tutores e retorna qual dos dois é o maior. A comparação utiliza como base o método {@link Aluno#compareTo(Aluno)}
	 * do atributo {@link #aluno}.
	 */
	public int compareTo(Tutor o) {
		return this.aluno.compareTo(o.aluno);
	}
	
}