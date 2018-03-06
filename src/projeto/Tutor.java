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
public class Tutor implements Comparable<Tutor> {
	/**
	 * Objeto Aluno ao qual o Tutor se refere.
	 */
	private Aluno aluno;
	/**
	 * Mapa de Disciplinas do Tutor, onde a chave  é o nome da disciplina e o valor é
	 * a proficiência do tutor na dada disciplina.
	 */
	private Map<String, Integer> disciplinas;
	/**
	 * Dinheiro recebido pelo Tutor.
	 */
	private double dinheiro;
	/**
	 * Lista de notas de avaliação do Tutor.
	 */
	private double notaAvaliacaoTutor;

	/**
	 * Lista de locais cadastrados de um tutor
	 */
	private List<String> locais;
	/**
	 * Lista de horários cadastrados de um tutor
	 */
	private List<String> horarios;

	/**
	 * Construtor de Tutor, inicializa os argumentos da classe.
	 * 
	 * @param disciplina
	 *            nome da primeira disciplina do Tutor
	 * @param proficiencia
	 *            proficiência da primeira disciplina
	 * @param aluno
	 *            referência ao objeto aluno que se tornou Tutor
	 */
	public Tutor(String disciplina, int proficiencia, Aluno aluno) {
		this.disciplinas = new HashMap<String, Integer>();
		this.disciplinas.put(disciplina, proficiencia);
		this.aluno = aluno;
		this.dinheiro = 0;
		this.notaAvaliacaoTutor = 4.00;
		this.locais = new ArrayList<String>();
		this.horarios = new ArrayList<String>();
	}

	/**
	 * Método que adiciona mais uma disciplina de tutoria ao Tutor.
	 * 
	 * @param disciplina
	 *            nome da disciplina
	 * @param proficiencia
	 *            valor de proficiência do Tutor
	 */
	public void adicionarDisciplina(String disciplina, int proficiencia) {
		if (this.disciplinas.containsKey(disciplina)) {
			throw new IllegalArgumentException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
		}
		this.disciplinas.put(disciplina, proficiencia);
	}

	/**
	 * Método que retorna a média de avaliações do Tutor.
	 * 
	 * @return Double com a média de avaliações do Tutor.
	 */
	public String pegarNota() {
		return String.format("%,.2f", this.notaAvaliacaoTutor);
	}

	/**
	 * Método que adiciona um horario na lista de horarios de um tutor
	 * 
	 * @param horario
	 * @param dia
	 */
	public void cadastrarHorario(String horario, String dia) {
		this.horarios.add(horario + " - " + dia);
	}

	/**
	 * Método que adiciona um local de atendimento na lista de locais de um tutor
	 * 
	 * @param local
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		this.locais.add(local);
	}

	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * Método que retorna a lista de locais de um tutor
	 * 
	 * @return
	 */
	public List<String> getLocais() {
		return locais;
	}

	/**
	 * Método que retorna a lista de horarios de um tutor
	 * 
	 * @return
	 */
	public List<String> getHorarios() {
		return horarios;
	}

	/**
	 * Método hashCode com cálculo baseado no atributo que armazena um objeto aluno,
	 * ou seja, {@link #aluno}.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		return result;
	}

	/**
	 * Método equals com comparação baseada no atributo que armazena um objeto
	 * aluno, ou seja, {@link #aluno}.
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
	 * Método que gera a representação em String de um tutor. Utiliza o método
	 * {@link Aluno#toString()} do atributo {@link #aluno}.
	 */
	@Override
	public String toString() {
		return this.aluno.toString();

	}

	/**
	 * Método que compara dois tutores e retorna qual dos dois é o maior. A
	 * comparação utiliza como base o método {@link Aluno#compareTo(Aluno)} do
	 * atributo {@link #aluno}.
	 */
	public int compareTo(Tutor o) {
		return this.aluno.compareTo(o.aluno);
	}

	/**
	 * Método que avalia se o tutor é proficiente em determinada disciplina.
	 * 
	 * @param disciplina
	 *            a disciplina de checagem de proficiencia do tutor.
	 * 
	 */

	public boolean isProficiente(String disciplina) {
		return disciplinas.containsKey(disciplina);
	}

	/**
	 * Método que avalia se o tutor está disponível para realizar um atendimento, de
	 * acordo com o horaio, dia e local de interesse do atendimento.
	 * 
	 * @param horario
	 *            horario de atendimento a ser checado.
	 * @param dia
	 *            dia de atendimento a ser checado.
	 * @param localInteresse
	 *            local de interesse para atendimento.
	 */
	public boolean isDisponivel(String horario, String dia, String localInteresse) {
		return horarios.contains(horario + " - " + dia) && locais.contains(localInteresse);
	}

	/**
	 * Método que recupera a nota de proficiencia do tutor em determinada disciplina
	 * passada como parâmetro.
	 * @param disciplina disciplina de interesse da nota de proficiencia do tutor.
	 */
	public int getPontuacao(String disciplina) {
		return disciplinas.get(disciplina);
	}

	/**
	 * Método que avalia um tutor por uma ajuda que ele realizou.
	 * @param nota nota de avaliação do tutor pela ajuda.
	 */
	public String avaliarTutor(int nota) {
		this.notaAvaliacaoTutor = ((this.notaAvaliacaoTutor * 5) + nota) / 6;
		return String.format("%,.2f", notaAvaliacaoTutor);
	}

	/**
	 * Método que avalia o nível do tutor, de acordo com sua nota de avaliação.
	 */
	public String pegarNivel() {
		if (notaAvaliacaoTutor > 4.5) {
			return "TOP";
		} else if (notaAvaliacaoTutor > 3) {
			return "Tutor";
		} else {
			return "Aprendiz";
		}
	}
	/**
	 * Método que recebe a quantidade de dinheiro a ser fornecido a um tutor.
	 * @param totalTutor
	 */
	public void recebeDinheiro(double totalTutor) {
		this.dinheiro += totalTutor;
	}
	/**
	 * Método que retorna o total de dinheiro pertencente a um tutor
	 * @return
	 */
	public double totalDinheiroTutor() {
		return  this.dinheiro;
	}
	/**
	 * Método que retorna a nota de avaliacao de um tutor
	 * @return
	 */
	public double getNotaAvaliacao() {
		return this.notaAvaliacaoTutor;
	}

}