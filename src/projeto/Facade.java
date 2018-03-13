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
	private Controller controller;
	
	/**
	 * Construtor da Classe Facade que inicializa os controllers.
	 */
	public Facade() {
		this.controller = new Controller();
	}
	
	/**
	 * Método main para execução dos testes do EasyAccept.
	 * @param args array de argumentos
	 */
	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt", "acceptance_test/us3_test.txt",
							"acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt", "acceptance_test/us6_test.txt"};
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
		this.controller.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	/**
	 * Método que retorna as informações de um aluno no sistema. Utiliza o método {@link AlunoController#recuperaAluno(String)} da classe 
	 * {@link AlunoController}.
	 * @param matricula matrícula do aluno
	 * @return String com as informações do aluno com a respectiva matrícula
	 */
	public String recuperaAluno(String matricula) {
		return this.controller.recuperaAluno(matricula);
	}
	
	/**
	 * Método que gera uma listagem de todos os Alunos cadastrados no sistema ordenados por ordem alfabética pelo nome.
	 * Utiliza o método {@link AlunoController#listarAlunos()} da classe {@link AlunoController}.
	 * @return String com a listagem dos alunos
	 */
	public String listarAlunos() {
		return this.controller.listarAlunos();
	}
	
	/**
	 * Método que retorna uma infomação específica do aluno (atributo) de acordo com o solicitado. Utiliza o método {@link AlunoController#getInfoAluno(String, String)} 
	 * da classe {@link AlunoController}.
	 * @param matricula matrícula do aluno
	 * @param atributo atributo desejado
	 * @return String com a informação do atributo informado
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return this.controller.getInfoAluno(matricula, atributo);
	}
	
	/**
	 * Método que torna um Aluno em Tutor. Utiliza os métodos {@link TutorController#tornarTutor(String, String, int, Aluno)} da classe {@link TutorController} e 
	 * {@link AlunoController#tornarTutor(String)} da classe {@link AlunoController}.
	 * @param matricula matrícula do aluno
	 * @param disciplina disciplina de tutoria
	 * @param proficiencia proficiência do aluno na disciplina
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.controller.tornarTutor(matricula, disciplina, proficiencia);
	}
	
	/**
	 * Método que retorna as informações do Tutor respectivo à matrícula informada. Utiliza o método {@link TutorController#recuperaTutor(String)} da classe
	 * {@link TutorController}.
	 * @param matricula matrícula do tutor
	 * @return String com as informações do tutor
	 */
	public String recuperaTutor(String matricula) {
		return this.controller.recuperaTutor(matricula);
	}
	
	/**
	 * Método que retorna uma listagem dos Tutores cadastrados no sistema. Utiliza o método {@link TutorController#listarTutores()} da classe
	 * {@link TutorController}.
	 * @return
	 */
	public String listarTutores() {
		return this.controller.listarTutores();
	}
	
	/**
	 * Méotodo que cadastra um horário de atendimento de um Tutor cadastrado no sistema. Utiliza o método {@link TutorController#cadastrarHorario(String, String, String)}
	 * da classe {@link TutorController}.
	 * @param email e-mail do tutor
	 * @param horario horário disponível do tutor
	 * @param dia dia disponível para o tutor
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		this.controller.cadastrarHorario(email, horario, dia);
	}
	
	/**
	 * Méotodo que cadastra um local de atendimento de um Tutor cadastrado no sistema. Utiliza o método {@link TutorController#cadastrarLocalDeAtendimento(String, String)}
	 * da classe {@link TutorController}.
	 * @param email e-mail do tutor
	 * @param local local disponível para o tutor
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.controller.cadastrarLocalDeAtendimento(email, local);
	}
	
	/**
	 * Método que verifica se o Tutor tem disponibilidade no horário e dias passados como argumento. Utiliza o método {@link TutorController#consultaHorario(String, String, String)}
	 * da classe {@link TutorController}.
	 * @param email e-mail do tutor
	 * @param horario horário de atendimento
	 * @param dia dia de atendimento
	 * @return Boolean representando a disponibilidade, true, caso esteja disponível, ou false, caso não
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.controller.consultaHorario(email, horario, dia);
	}
	
	/**
	 * Método que verifica se o Tutor tem disponibilidade no local passado como argumento. Utiliza o método {@link TutorController#consultaLocal(String, String)}
	 * da classe {@link TutorController}.
	 * @param email e-mail do tutor
	 * @param local local de atendimento
	 * @return Boolean representando a disponibilidade, true, caso esteja disponível, ou false, caso não
	 */
	public boolean consultaLocal(String email, String local) {
		return this.controller.consultaLocal(email, local);
	}

	/**
	 * Método de cadastro de uma ajuda presencial. Utiliza o método {@link TutorController#pedirAjudaPresencial(String, String, String, String, String)}
	 * da classe {@link TutorController}.
	 * 
	 * @param matrAluno matrícula do aluno solicitante
	 * @param disciplina disciplina da ajuda
	 * @param horario horário solicitado
	 * @param dia dia solicitado
	 * @param localInteresse local solicitado
	 * @return Inteiro que representa o ID da ajuda
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		return this.controller.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}

	/**
	 * Método de cadastro de uma ajuda presencial. Utiliza o método {@link TutorController#pedirAjudaOnline(String, String)}
	 * da classe {@link TutorController}.
	 * 
	 * @param matrAluno matrícula do aluno solicitante
	 * @param disciplina disciplina da ajuda
	 * @return Inteiro que representa o ID da ajuda
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return this.controller.pedirAjudaOnline(matrAluno, disciplina);
	}

	/**
	 * Método que obtem as informações de uma Ajuda e do Tutor responsável. Utiliza o método {@link TutorController#pegarTutor(int)}
	 * da classe {@link TutorController}.
	 * 
	 * @param idAjuda ID da ajuda
	 * @return String com as informações do tutor e da ajuda
	 */
	public String pegarTutor(int idAjuda) {
		return this.controller.pegarTutor(idAjuda);

	}

	/**
	 * Método que obtem as informações dos atributos de uma Ajuda. Utiliza o método {@link TutorController#getInfoAjuda(int, String)}
	 * da classe {@link TutorController}.
	 * 
	 * @param idAjuda ID da ajuda
	 * @param atributo atributo desejado
	 * @return String com o atributo desejado
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.controller.getInfoAjuda(idAjuda, atributo);
	}

	/**
	 * Método que avalia um tutor por uma ajuda realizada, retornando sua nota de avaliação final. Utiliza o método {@link TutorController#avaliarTutor(int, int)}
	 * da classe {@link TutorController}.
	 * 
	 * @param idAjuda identificador da ajuda de interesse.
	 * @param nota nota de avaliação do tutor por sua ajuda.
	 * @return String com a nova média do tutor.
	 */
	public String avaliarTutor(int idAjuda, int nota) {
		return this.controller.avaliarTutor(idAjuda, nota);
	}

	/**
	 * Método que retorna a nota de avaliação de um tutor. Utiliza o método {@link TutorController#pegarNota(String)}
	 * da classe {@link TutorController}.
	 * 
	 * @param matriculaTutor matrícula do tutor de interesse.
	 * @return String com a nota de avaliação do tutor
	 */
	public String pegarNota(String matriculaTutor) {
		return this.controller.pegarNota(matriculaTutor);
	}

	/**
	 * Método que retorna o nível de um tutor, de acordo com sua nota de avaliação. Utiliza o método {@link TutorController#pegarNivel(String)}
	 * da classe {@link TutorController}.
	 * 
	 * @param matriculaTutor matrícula do tutor de interesse.
	 * @return String com o nível do tutor
	 */
	public String pegarNivel(String matriculaTutor) {
		return this.controller.pegarNivel(matriculaTutor);
	}
	
	/**
	 * Método que objetifica uma doação para um tutor e também o dinheiro a ser adicionado no sistema.
	 * @param matriculaTutor
	 * @param totalCentavos
	 */

	public void doar(String matriculaTutor, int totalCentavos) {
		this.controller.doar(matriculaTutor, totalCentavos);
	}
	
	/**
	 * Método que retorna o inteiro correspondente ao total de dinheiro de um tutor passado como parametro.
	 * @param emailTutor
	 * @return
	 */
	
	public int totalDinheiroTutor(String emailTutor) {
		return this.controller.totalDinheiroTutor(emailTutor);
	}
	
	/**
	 * Método que retorna o total de dinheiro disponivel no caixa do sistema.
	 * @return
	 */
	public int totalDinheiroSistema() {
		return this.controller.totalDinheiroSistema();
	}
	
	
	public void configurarOrdem(String atributo) {
		this.controller.configurarOrdem(atributo);
		this.controller.configurarOrdem(atributo);
	}
	
}