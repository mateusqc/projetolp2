package ajuda;

/**
 * Classe que representa uma Ajuda Presencial no sistema QUEM ME AJUDA.
 * É filha da classe {@link Ajuda}.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 */
public class AjudaPresencial extends Ajuda {

	/**
	 * Horário da Ajuda.
	 */
	private String horario;
	/**
	 * Dia da Ajuda.
	 */
	private String dia;
	/**
	 * Local da Ajuda.
	 */
	private String localInteresse;

	/**
	 * Construtor de uma Ajuda Presencial, inicializa os atributos e utiliza o construtor da classe abstrata pai.
	 * @param matriculaAluno matrícula do aluno ajudado
	 * @param disciplina disciplina da ajuda
	 * @param horario horário da ajuda
	 * @param dia dia da ajuda
	 * @param localInteresse local da ajuda
	 * @param matriculaTutor tutor responsável pela ajuda
	 */
	public AjudaPresencial(String matriculaAluno, String disciplina, String horario, String dia, String localInteresse, String matriculaTutor) {
		super(matriculaAluno, disciplina, matriculaTutor);
		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;

	}

	/**
	 * Método que retorna as informações do Tutor responsável e da ajuda.
	 * @return String com as informações do tutor e da ajuda
	 */
	@Override
	public String pegarTutor() {
		return "Tutor - " + this.matriculaTutor + ", horario - " + this.horario + ", dia - " + this.dia + ", local - " + this.localInteresse + ", disciplina - " + this.disciplina;
	}

	/**
	 * Método que retorna informações da ajuda de acordo com o atributo desejado.
	 * @param atributo atributo desejado
	 * @return String com o atributo solicitado
	 */
	@Override
	public String getInfoAjuda(String atributo) {
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
		switch (atributo) {
		case "horario":
			return this.horario;
		case "dia":
			return this.dia;
		case "localInteresse":
			return this.localInteresse;
		case "disciplina":
			return super.getDisciplina();
		default:
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}

}
