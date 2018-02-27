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

	private AlunoController alunoController;
	private TutorController tutorController;
	
	public Facade() {
		this.alunoController = new AlunoController();
		this.tutorController = new TutorController();
	}
	
	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt"};
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
}