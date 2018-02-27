package projeto;

import easyaccept.EasyAccept;

/**
 * Classe de Fachada para os Controllers do QUEM ME AJUDA.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
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
		args = new String[] { "projeto.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt"};
		EasyAccept.main(args);
	}
	
	/**
	 * Método que cadastra um novo Aluno no sistema. Utiliza o método {@link AlunoController#cadastrarAluno(String, String, int, String, String)} da
	 * classe {@link AlunoController}.
	 * @param nome nome do aluno
	 * @param matricula matrícula do aluno
	 * @param codigoCurso código do curso do aluno
	 * @param telefone telefone do aluno
	 * @param email e-mail do aluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.alunoController.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	/**
	 * Método que retorna as informações de um aluno no sistema. Utiliza o método {@link AlunoController#recuperaAluno(String)} da classe 
	 * {@link AlunoController}.
	 * @param matricula matrícula do aluno
	 * @return String com as informações do aluno com a respectiva matrícula
	 */
	public String recuperaAluno(String matricula) {
		return this.alunoController.recuperaAluno(matricula);
	}
	
	/**
	 * Método que gera uma listagem de todos os Alunos cadastrados no sistema ordenados por ordem alfabética pelo nome.
	 * Utiliza o método {@link AlunoController#listarAlunos()} da classe {@link AlunoController}.
	 * @return String com a listagem dos alunos
	 */
	public String listarAlunos() {
		return this.alunoController.listarAlunos();
	}
	
	/**
	 * Método que retorna uma infomação específica do aluno (atributo) de acordo com o solicitado. Utiliza o método {@link AlunoController#getInfoAluno(String, String)} 
	 * da classe {@link AlunoController}.
	 * @param matricula matrícula do aluno
	 * @param atributo atributo desejado
	 * @return String com a informação do atributo informado
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return this.alunoController.getInfoAluno(matricula, atributo);
	}
	
	/**
	 * Método que torna um Aluno em Tutor. Utiliza os métodos {@link TutorController#tornarTutor(String, String, int, Aluno)} da classe {@link TutorController} e 
	 * {@link AlunoController#tornarTutor(String)} da classe {@link AlunoController}.
	 * @param matricula
	 * @param disciplina
	 * @param proficiencia
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.tutorController.tornarTutor(matricula, disciplina, proficiencia, this.alunoController.tornarTutor(matricula));
	}
	
	/**
	 * Método que retorna as informações do Tutor respectivo à matrícula informada. Utiliza o método {@link TutorController#recuperaTutor(String)} da classe
	 * {@link TutorController}.
	 * @param matricula matrícula do tutor
	 * @return String com as informações do tutor
	 */
	public String recuperaTutor(String matricula) {
		return this.tutorController.recuperaTutor(matricula);
	}
	
	/**
	 * Método que retorna uma listagem dos Tutores cadastrados no sistema. Utiliza o método {@link TutorController#listarTutores()} da classe
	 * {@link TutorController}.
	 * @return
	 */
	public String listarTutores() {
		return this.tutorController.listarTutores();
	}
}