package projeto;

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
public class Controller {
	/**
	 * Controller de Alunos.
	 */
	private AlunoController alunoController;
	/**
	 * Controller de Tutores.
	 */
	private TutorController tutorController;
	/**
	 * Controller de Ajudas.
	 */
	private AjudaController ajudaController;
	
	/**
	 * Construtor da Classe Facade que inicializa os controllers.
	 */
	public Controller() {
		this.alunoController = new AlunoController();
		this.tutorController = new TutorController();
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
	 * @param matricula matrícula do aluno
	 * @param disciplina disciplina de tutoria
	 * @param proficiencia proficiência do aluno na disciplina
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		try {
			this.tutorController.tornarTutor(matricula, disciplina, proficiencia, this.alunoController.getAluno(matricula));
		} catch (IllegalArgumentException iae) {
			if (iae.getMessage().equals("Aluno nao encontrado")) {
			throw new IllegalArgumentException("Erro na definicao de papel: Tutor nao encontrado");
			} else {
				throw iae;
			}
		}
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
	
	/**
	 * Méotodo que cadastra um horário de atendimento de um Tutor cadastrado no sistema. Utiliza o método {@link TutorController#cadastrarHorario(String, String, String)}
	 * da classe {@link TutorController}.
	 * @param email e-mail do tutor
	 * @param horario horário disponível do tutor
	 * @param dia dia disponível para o tutor
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		this.tutorController.cadastrarHorario(email, horario, dia);
	}
	
	/**
	 * Méotodo que cadastra um local de atendimento de um Tutor cadastrado no sistema. Utiliza o método {@link TutorController#cadastrarLocalDeAtendimento(String, String)}
	 * da classe {@link TutorController}.
	 * @param email e-mail do tutor
	 * @param local local disponível para o tutor
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.tutorController.cadastrarLocalDeAtendimento(email, local);
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
		return this.tutorController.consultaHorario(email, horario, dia);
	}
	
	/**
	 * Método que verifica se o Tutor tem disponibilidade no local passado como argumento. Utiliza o método {@link TutorController#consultaLocal(String, String)}
	 * da classe {@link TutorController}.
	 * @param email e-mail do tutor
	 * @param local local de atendimento
	 * @return Boolean representando a disponibilidade, true, caso esteja disponível, ou false, caso não
	 */
	public boolean consultaLocal(String email, String local) {
		return this.tutorController.consultaLocal(email, local);
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
		return this.ajudaController.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse, this.tutorController.getTutorDisponivel(disciplina, horario, dia, localInteresse).getAluno().getMatricula());
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
		return this.ajudaController.pedirAjudaOnline(matrAluno, disciplina, this.tutorController.getTutorDisponivel(disciplina).getAluno().getMatricula());
	}

	/**
	 * Método que obtem as informações de uma Ajuda e do Tutor responsável. Utiliza o método {@link TutorController#pegarTutor(int)}
	 * da classe {@link TutorController}.
	 * 
	 * @param idAjuda ID da ajuda
	 * @return String com as informações do tutor e da ajuda
	 */
	public String pegarTutor(int idAjuda) {
		return this.ajudaController.pegarTutor(idAjuda);

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
		return this.ajudaController.getInfoAjuda(idAjuda, atributo);
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
		return this.tutorController.avaliarTutor(this.ajudaController.avaliaAjuda(idAjuda), nota);
	}

	/**
	 * Método que retorna a nota de avaliação de um tutor. Utiliza o método {@link TutorController#pegarNota(String)}
	 * da classe {@link TutorController}.
	 * 
	 * @param matriculaTutor matrícula do tutor de interesse.
	 * @return String com a nota de avaliação do tutor
	 */
	public String pegarNota(String matriculaTutor) {
		return this.tutorController.pegarNota(matriculaTutor);
	}

	/**
	 * Método que retorna o nível de um tutor, de acordo com sua nota de avaliação. Utiliza o método {@link TutorController#pegarNivel(String)}
	 * da classe {@link TutorController}.
	 * 
	 * @param matriculaTutor matrícula do tutor de interesse.
	 * @return String com o nível do tutor
	 */
	public String pegarNivel(String matriculaTutor) {
		return this.tutorController.pegarNivel(matriculaTutor);
	}
	
	/**
	 * Método que objetifica uma doação para um tutor e também o dinheiro a ser adicionado no sistema.
	 * @param matriculaTutor
	 * @param totalCentavos
	 */

	public void doar(String matriculaTutor, int totalCentavos) {
		this.tutorController.doar(matriculaTutor, totalCentavos);
	}
	
	/**
	 * Método que retorna o inteiro correspondente ao total de dinheiro de um tutor passado como parametro.
	 * @param emailTutor
	 * @return
	 */
	
	public int totalDinheiroTutor(String emailTutor) {
		return this.tutorController.totalDinheiroTutor(emailTutor);
	}
	
	/**
	 * Método que retorna o total de dinheiro disponivel no caixa do sistema.
	 * @return
	 */
	public int totalDinheiroSistema() {
		return this.tutorController.getCaixaSistema();
	}
	
	
	public void configurarOrdem(String atributo) {
		this.alunoController.configurarOrdem(atributo);
		this.tutorController.configurarOrdem(atributo);
	}
	
}