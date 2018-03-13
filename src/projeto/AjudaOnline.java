package projeto;

/**
 * Classe que representa uma Ajuda Online no sistema QUEM ME AJUDA.
 * É filha da classe {@link Ajuda}.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 */
public class AjudaOnline extends Ajuda {
	
	/**
	 * Construtor de uma Ajuda Online, utiliza o construtor da classe abstrata pai.
	 * @param matriculaAluno
	 * @param disciplina
	 * @param matriculaTutor
	 */
	public AjudaOnline(String matriculaAluno, String disciplina,String matriculaTutor) {
		super(matriculaAluno,disciplina,matriculaTutor);
	}

	/**
	 * Método que retorna as informações do Tutor responsável e da ajuda.
	 * @return String com as informações do tutor e da ajuda
	 */
	@Override
	public String pegarTutor() {
		return "Tutor - " + this.matriculaTutor + ", disciplina - " + this.disciplina;
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
		if (atributo.equals("disciplina")) {
			return super.getDisciplina();
		}
		throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
	}

}
