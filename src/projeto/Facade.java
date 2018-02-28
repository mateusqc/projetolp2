package projeto;

import easyaccept.EasyAccept;

/**
 * Classe de Fachada para os Controllers do QUEM ME AJUDA.
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 *
 */
public class Facade {
	/**
	 * Controller de Alunos.
	 */
	private AlunoController alunoController;
	/**
	 * Controller de Tutores.
	 */
	private TutorController tutorController;
	
	/**
	 * Construtor da Classe Facade que inicializa os controllers.
	 */
	public Facade() {
		this.alunoController = new AlunoController();
		this.tutorController = new TutorController();
	}
	
	/**
	 * Método main para execução dos testes do EasyAccept.
	 * @param args array de argumentos
	 */
	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt", "acceptance_test/us3_test.txt"};
		EasyAccept.main(args);
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.alunoController.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String recuperaAluno(String matricula) {
		return this.alunoController.recuperaAluno(matricula);
	}
	
	public String listarAlunos() {
		return this.alunoController.listarAlunos();
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return this.alunoController.getInfoAluno(matricula, atributo);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.tutorController.tornarTutor(matricula, disciplina, proficiencia, this.alunoController.tornarTutor(matricula));
	}
	
	public String recuperaTutor(String matricula) {
		return this.tutorController.recuperaTutor(matricula);
	}
	
	public String listarTutores() {
		return this.tutorController.listarTutores();
	}
	
	/**
	 * Método que recebe os parametros necessários e realiza cadastro de horario de um tutor
	 * @param email
	 * @param horario
	 * @param dia
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		this.tutorController.cadastrarHorario(email, horario, dia);
	}
	
	/**
	 * Método que recebe os parametros necessários e realiza cadastro do local de atendimento de um tutor
	 * @param email
	 * @param local
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.tutorController.cadastrarLocalDeAtendimento(email, local);
	}
	
	/**
	 * Método que verifica se um determinado tutor possui o horario passado para verificação
	 * @param email
	 * @param horario
	 * @param dia
	 * @return
	 */
	public boolean consultaHorario(String email, String horario,String dia) {
		return this.tutorController.consultaHorario(email, horario, dia);
	}
	
	/**
	 * Método que verifica se um determinado tutor possui o local passado para verificação
	 * @param email
	 * @param local
	 * @return
	 */
	public boolean consultaLocal(String email, String local) {
		return this.tutorController.consultaLocal(email, local);
	}
}