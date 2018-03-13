package ajuda;

/**
 * Classe abstrata que representa uma Ajuda no sistema QUEM ME AJUDA.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 */
public abstract class Ajuda {
	/**
	 * Matrícula do Aluno solicitante da ajuda.
	 */
	private String matriculaAluno;
	/**
	 * Disciplina da ajuda solicitada.
	 */
	protected String disciplina;
	/**
	 * Matrícula do Tutor responsável pela ajuda.
	 */
	protected String matriculaTutor;
	/**
	 * Boolean que armazena o estado da ajuda de avaliada ou não.
	 */
	private boolean foiAvaliado;
	
	/**
	 * Construtor de uma Ajuda, inicializa todos os atributos da mesma.
	 * @param matricula Aluno matrícula do aluno ajudado
	 * @param disciplina disciplina da ajuda
	 * @param matriculaTutor Tutor responsável pela ajuda
	 */
	public Ajuda (String matriculaAluno, String disciplina,String matriculaTutor) {
		this.matriculaAluno = matriculaAluno;
		this.disciplina = disciplina;
		this.matriculaTutor = matriculaTutor;
		this.foiAvaliado = false;
	}

	/**
	 * Método get para a matrícula do Aluno solicitante da ajuda.
	 * @return String com a matrícula do aluno
	 */
	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	/**
	 * Método get para a disciplina da ajuda solicitada.
	 * @return String com a disciplina da ajuda
	 */
	public String getDisciplina() {
		return disciplina;
	}

	/**
	 * Método get para a matrícula do Tutor responsável pela ajuda.
	 * @return String com a matrícula do Tutor
	 */
	public String getMatriculaTutor() {
		return matriculaTutor;
	}
	
	/**
	 * Método abstrato que retorna as informações do Tutor responsável e da ajuda.
	 * @return String com as informações do tutor e da ajuda
	 */
	public abstract String pegarTutor();

	/**
	 * Método que retorna o estado da Ajuda, ou seja, se foi avaliada ou não.
	 * @return Boolean representando se foi avaliada (true) ou não (false)
	 */
	public boolean foiAvaliado() {
		return this.foiAvaliado;
	}
	
	/**
	 * Método que muda o estado da ajuda, ou seja, a torna avaliada.
	 */
	public void avaliaAjuda() {
		this.foiAvaliado = true;
	}
	
	/**
	 * Método abstrato que retorna informações da ajuda.
	 * @param atributo atributo desejado
	 * @return String com o atributo solicitado
	 */
	public abstract String getInfoAjuda(String atributo);

}
