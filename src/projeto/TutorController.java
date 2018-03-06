package projeto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe que representa o Controller de Alunos do QUEM ME AJUDA.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 */
public class TutorController {
	private Map<String, Tutor> tutores;

	private ArrayList<Ajuda> ajudas;
	
	private double caixaSistema;

	/**
	 * Construtor de TutorController. Inicializa o mapa de tutores.
	 */
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
		this.ajudas = new ArrayList<Ajuda>();

	}

	/**
	 * Método que torna um aluno tutor. O Tutor irá armazenar o Aluno que virou
	 * tutor como parâmetro, por isso é passado o objeto aluno.
	 * 
	 * @param matricula
	 *            matrícula do aluno
	 * @param disciplina
	 *            primeira disciplina da tutoria
	 * @param proficiencia
	 *            proeficiência na primeira disciplina
	 * @param aluno
	 *            objeto de referência ao aluno que virou tutor
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia, Aluno aluno) {
		if (proficiencia < 1 || proficiencia > 5) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
		if (!tutores.containsKey(matricula)) {
			this.tutores.put(matricula, new Tutor(disciplina, proficiencia, aluno));
		} else {
			this.tutores.get(matricula).adicionarDisciplina(disciplina, proficiencia);
		}
	}

	/**
	 * Método que obtém as informações do tutor com a respectiva matrícula informada
	 * e as retorna numa String.
	 * 
	 * @param matricula
	 *            matrícula do tutor
	 * @return String com as informações do Tutor
	 */
	public String recuperaTutor(String matricula) {
		if (!tutores.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por tutor: Tutor nao encontrado");
		}

		return this.tutores.get(matricula).toString();

	}

	/**
	 * Método que gera uma listagem dos tutores cadastrados no sistema, ordenada em
	 * ordem alfabética com base no nome do tutor.
	 * 
	 * @return String com a listagem ordenada dos tutores
	 */
	public String listarTutores() {

		List<Tutor> tutoresOrdenadosNome = new ArrayList<Tutor>();

		for (Tutor tutor : this.tutores.values()) {
			tutoresOrdenadosNome.add(tutor);
		}

		Collections.sort(tutoresOrdenadosNome);

		String tutoresListados = "";
		for (int i = 0; i < tutoresOrdenadosNome.size(); i++) {
			tutoresListados += tutoresOrdenadosNome.get(i).toString() + ", ";
		}
		return tutoresListados.substring(0, tutoresListados.length() - 2);

	}

	/**
	 * Método que recebe os parametros necessários, verifica a validade e realiza
	 * cadastro de horario de um tutor
	 * 
	 * @param email
	 * @param horario
	 * @param dia
	 */
	public void cadastrarHorario(String email, String horario, String dia) {

		if (email.trim().equals("") || email == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}

		if (horario.trim().equals("") || horario == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}

		if (dia.trim().equals("") || horario == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}

		int ajuda = 0;
		for (Tutor tutor : this.tutores.values()) {

			if (tutor.getAluno().getEmail().equals(email)) {
				tutor.cadastrarHorario(horario, dia);
				ajuda += 1;
				break;
			}
		}
		if (ajuda == 0) {
			throw new IllegalArgumentException("Erro no cadastrar horario: tutor nao cadastrado");
		}
	}

	/**
	 * Método que recebe os parametros necessários, verifica a validade e realiza
	 * cadastro do local de atendimento de um tutor
	 * 
	 * @param email
	 * @param local
	 */

	public void cadastrarLocalDeAtendimento(String email, String local) {

		if (email.trim().equals("") || email == null) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}

		if (local.trim().equals("") || local == null) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}

		int ajuda = 0;
		for (Tutor tutor : this.tutores.values()) {
			if (tutor.getAluno().getEmail().equals(email)) {
				tutor.cadastrarLocalDeAtendimento(local);
				ajuda += 1;
				break;
			}
		}
		if (ajuda == 0) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
	}

	/**
	 * Método que verifica se um determinado tutor possui o horario passado para
	 * verificação
	 * 
	 * @param email
	 * @param horario
	 * @param dia
	 * @return
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		for (Tutor tutor : this.tutores.values()) {
			if (tutor.getAluno().getEmail().equals(email)) {
				System.out.println(tutor.getHorarios().contains(horario + " - " + dia));
				if (tutor.getHorarios().contains(horario + " - " + dia)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Método que verifica se um determinado tutor possui o local passado para
	 * verificação
	 * 
	 * @param email
	 * @param local
	 * @return
	 */
	public boolean consultaLocal(String email, String local) {
		for (Tutor tutor : this.tutores.values()) {
			if (tutor.getAluno().getEmail().equals(email)) {
				if (tutor.getLocais().contains(local)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Na ajuda presencial, o aluno indica a disciplina e dia que quer uma ajuda e o
	 * local que tem interesse. Ao realizar um pedido no sistema, o sistema deve
	 * associar um tutor a esse pedido. O tutor escolhido precisa ter proficiência
	 * na disciplina e disponibilidade no local e no horário/dia indicado.
	 * 
	 * Caso mais de um tutor esteja disponível naquele dia o de maior pontuação deve
	 * ser retornado (ou o primeiro aluno cadastrado em caso de empate). O mesmo
	 * tutor pode ser retornado para vários pedidos de ajuda diferentes.
	 * 
	 * 
	 */

	private Tutor getTutorAjudaPresencial(String disciplina, String horario, String dia, String localInteresse) {

		Tutor tutorEscolhido = null;

		for (Tutor tutor : tutores.values()) {

			if (tutor.isDisponivel(horario, dia, localInteresse) && tutor.isProficiente(disciplina)) {
				if (tutorEscolhido == null)
					tutorEscolhido = tutor;
				else {

					if (tutorEscolhido.getPontuacao(disciplina) < tutor.getPontuacao(disciplina))
						tutorEscolhido = tutor;
					else if (tutorEscolhido.getPontuacao(disciplina) == tutor.getPontuacao(disciplina)) {
						if (tutorEscolhido.getAluno().getPosicaoCadastro() > tutor.getAluno().getPosicaoCadastro())
							tutorEscolhido = tutor;
					}

				}

			}
		}
		return tutorEscolhido;
	}

	/**
	 * Na ajuda online, o aluno indica a disciplina de interesse por ajuda. Ao
	 * realizar um pedido no sistema, o sistema deve associar um tutor a esse
	 * pedido. O tutor escolhido precisa ter proficiência na disciplina.
	 * 
	 * Caso mais de um tutor esteja disponível para aquela disciplina,o de maior
	 * pontuação deve ser retornado (ou o primeiro aluno cadastrado em caso de
	 * empate). O mesmo tutor pode ser retornado para vários pedidos de ajuda
	 * diferentes.
	 * 
	 * 
	 */
	private Tutor getTutorAjudaOnline(String disciplina) {
		Tutor tutorEscolhido = null;

		for (Tutor tutor : tutores.values()) {
			if (tutor.isProficiente(disciplina)) {
				if (tutorEscolhido == null)
					tutorEscolhido = tutor;
				else {
					if (tutorEscolhido.getPontuacao(disciplina) < tutor.getPontuacao(disciplina))
						tutorEscolhido = tutor;
					else if (tutorEscolhido.getPontuacao(disciplina) == tutor.getPontuacao(disciplina)) {
						if (tutorEscolhido.getAluno().getPosicaoCadastro() > tutor.getAluno().getPosicaoCadastro())
							tutorEscolhido = tutor;
					}
				}
			}

		}

		return tutorEscolhido;
	}

	/**
	 * Método que realiza o cadastro de uma ajuda presencial.
	 * 
	 * @param matrAluno
	 *            matricula do aluno requisitando a ajuda.
	 * @param disciplina
	 *            disciplina de desejo de ajuda.
	 * @param horario
	 *            horario de atendimento para a ajuda.
	 * @param dia
	 *            dia de atendimento para a ajuda.
	 * @param localInteresse
	 *            local de atendimento da ajuda.
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		if (matrAluno.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
		if (horario.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
		if (dia.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
		if (localInteresse.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
		AjudaPresencial ajuda = new AjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse,
				getTutorAjudaPresencial(disciplina, horario, dia, localInteresse).getAluno().getMatricula());
		ajudas.add(ajuda);
		return ajudas.size();

	}

	/**
	 * Método que realiza o cadastro de uma ajuda presencial.
	 * 
	 * @param matrAluno
	 *            matricula do aluno requisitando a ajuda.
	 * @param disciplina
	 *            disciplina de desejo de ajuda.
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		if (matrAluno.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
		AjudaOnline ajuda = new AjudaOnline(matrAluno, disciplina,
				getTutorAjudaOnline(disciplina).getAluno().getMatricula());
		ajudas.add(ajuda);
		return ajudas.size();

	}

	/**
	 * Método que retorna o tutor responsável por determinada ajuda, identificada
	 * por seu id.
	 * 
	 * @param idAjuda
	 *            identificador da ajuda de interesse.
	 */
	public String pegarTutor(int idAjuda) {
		if (idAjuda < 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
		if (idAjuda > ajudas.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao encontrado ");
		}
		return ajudas.get(idAjuda - 1).pegarTutor();
	}

	/**
	 * Método que recupera determinada informação da ajuda.
	 * 
	 * @param idAjuda
	 *            o identificador da ajuda de interesse.
	 * @param atributo
	 *            o atributo que se quer recuperar da ajuda.
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		if (idAjuda < 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
		if (idAjuda > ajudas.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		}
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}

		Ajuda ajuda = ajudas.get(idAjuda - 1);

		switch (atributo) {
		case "horario":
			return ((AjudaPresencial) ajuda).getHorario();
		case "dia":
			return ((AjudaPresencial) ajuda).getDia();
		case "localInteresse":
			return ((AjudaPresencial) ajuda).getLocalInteresse();
		case "disciplina":
			return ajuda.getDisciplina();

		default:
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");

		}
	}

	/**
	 * Método que avalia um tutor por determinada ajuda realizada.
	 * 
	 * @param idAjuda
	 *            o identificador da ajuda de interesse.
	 * @param nota
	 *            nota de avaliação do tutor por sua ajuda.
	 */
	public String avaliarTutor(int idAjuda, int nota) {
		if (nota < 0) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser menor que 0");
		}
		if (nota > 5) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser maior que 5");
		}
		if (idAjuda < 0) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: id nao pode menor que zero ");
		}
		if (idAjuda > ajudas.size()) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: id nao encontrado ");
		}
		if (!ajudas.get(idAjuda - 1).foiAvaliado()) {
			ajudas.get(idAjuda - 1).avaliaAjuda();
			return tutores.get(ajudas.get(idAjuda - 1).getMatriculaTutor()).avaliarTutor(nota);
		} else {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}
	}

	/**
	 * Método que retorna a nota de avaliação de um tutor.
	 * 
	 * @param matriculaTutor
	 *            matrícula do tutor de interesse.
	 */
	public String pegarNota(String matriculaTutor) {

		return this.tutores.get(matriculaTutor).pegarNota();

	}

	/**
	 * Método que retorna o nível de determinado tutor, de acordo com sua nota de
	 * avaliação.
	 * 
	 * @param matriculaTutor
	 *            matrícula do tutor de interesse.
	 */
	public String pegarNivel(String matriculaTutor) {

		return this.tutores.get(matriculaTutor).pegarNivel();

	}
	/**
	 * Método que objetifica uma doação para um tutor e também o dinheiro a ser adicionado no sistema.
	 * @param matriculaTutor
	 * @param totalCentavos
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		
		if (matriculaTutor.trim().equals("") || matriculaTutor == null) {
			throw new IllegalArgumentException("Erro na doacao para tutor: matriculaTutor nao pode ser vazio ou nulo");
		}
		if (totalCentavos < 0) {
			throw new IllegalArgumentException("Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		}
		if (!this.tutores.containsKey(matriculaTutor)) {
			throw new IllegalArgumentException("Erro na doacao para tutor: Tutor nao encontrado");
		}
			
		double taxa = calculaTaxa(matriculaTutor);
		double dinheiroTutor = calculaValores(taxa, totalCentavos);
		this.tutores.get(matriculaTutor).recebeDinheiro(dinheiroTutor);
		this.caixaSistema += totalCentavos - dinheiroTutor;
	}
	/**
	 * Método que calcula o valor a ser recebido pelo tutor.
	 * @param taxa
	 * @param totalCentavos
	 * @return
	 */
	private double calculaValores(double taxa, int totalCentavos) {
				
		double totalSistema = Math.floor(((100 - ((taxa*100)))/100) * totalCentavos);
	
		
		return (totalCentavos - totalSistema);

	}
	/**
	 * Método que calcula a taxa a ser usada para definir os valores recebidos pelo tutor e pelo sistema
	 * @param matriculaTutor
	 * @return
	 */
	private double calculaTaxa(String matriculaTutor) {
		double taxa = 0;
		if (this.tutores.get(matriculaTutor).pegarNivel() == "TOP") {
			taxa = Math.floor(((this.tutores.get(matriculaTutor).getNotaAvaliacao() - 4.5) * 10) + 90);
		} else if (this.tutores.get(matriculaTutor).pegarNivel() == "Tutor") {
			taxa = 80; 
		} else {
			taxa = Math.ceil(40 - ((3 - this.tutores.get(matriculaTutor).getNotaAvaliacao()) * 10));
		} 
		
		taxa = taxa / 100;
		new DecimalFormat("0.00").format(taxa);
		return taxa;	
	}
	/**
	 * Método que retorna o inteiro correspondente ao total de dinheiro de um tutor.
	 * @param emailTutor
	 * @return
	 */
	public int totalDinheiroTutor(String emailTutor) { 
		if (emailTutor.trim().equals("") || emailTutor == null) {
			throw new IllegalArgumentException("Erro na consulta de total de dinheiro do tutor: emailTutor nao pode ser vazio ou nulo");
		}
	
		for (Tutor tutor : this.tutores.values()) {
			if (tutor.getAluno().getEmail().equals(emailTutor)) {
				return (int) tutor.totalDinheiroTutor();
			}
		} throw new IllegalArgumentException("Erro na consulta de total de dinheiro do tutor: Tutor nao encontrado");
	
	}
	
	/**
	 * Método que retorna o valor inteiro do caixa do sistema de tutores.
	 * @return
	 */
	public int getCaixaSistema() {
		return (int)caixaSistema;
	}
	
	
	
	
}
