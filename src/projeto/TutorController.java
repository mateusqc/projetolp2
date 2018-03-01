package projeto;

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
	private Map<String, String> emailTutores;
	
	/**
	 * Construtor de TutorController. Inicializa o mapa de tutores.
	 */
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
		this.emailTutores = new HashMap<String, String>();
	}
	
	/**
	 * Método que torna um aluno tutor. O Tutor irá armazenar o Aluno que virou tutor como parâmetro, por isso é passado o objeto aluno.
	 * @param matricula matrícula do aluno
	 * @param disciplina primeira disciplina da tutoria
	 * @param proficiencia proeficiência na primeira disciplina 
	 * @param aluno objeto de referência ao aluno que virou tutor
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia, Aluno aluno) {
		if(proficiencia < 1 || proficiencia > 5) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
		if(!tutores.containsKey(matricula)) {
			this.tutores.put(matricula, new Tutor(disciplina, proficiencia, aluno));
			this.emailTutores.put(aluno.getEmail(), matricula);
		} else {
			this.tutores.get(matricula).adicionarDisciplina(disciplina, proficiencia);
		}
	}
	
	/**
	 * Método que obtém as informações do tutor com a respectiva matrícula informada e as retorna numa String.
	 * @param matricula matrícula do tutor
	 * @return String com as informações do Tutor
	 */
	public String recuperaTutor(String matricula) {
		if(!tutores.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por tutor: Tutor nao encontrado");
		}
		
		return this.tutores.get(matricula).toString();
	
	}

	/**
	 * Método que gera uma listagem dos tutores cadastrados no sistema, ordenada em ordem alfabética com base no nome do tutor.
	 * @return String com a listagem ordenada dos tutores
	 */
	public String listarTutores() {
		
		List<Tutor> tutoresOrdenadosNome = new ArrayList<Tutor>();
		
		for(Tutor tutor : this.tutores.values()) {
			tutoresOrdenadosNome.add(tutor);
		}
		
		Collections.sort(tutoresOrdenadosNome);
		
		String tutoresListados = "";
		for(int i=0; i < tutoresOrdenadosNome.size(); i++) {
			tutoresListados += tutoresOrdenadosNome.get(i).toString() + ", ";
		}
		return tutoresListados.substring(0, tutoresListados.length() - 2);
		
	}
	
	/**
	 * Método que recebe os parametros necessários, verifica a validade e realiza cadastro de horario de atendimento de um tutor.
	 * @param email email do tutor
	 * @param horario horário de atendimento
	 * @param dia dia de atendimento
	 */
	public void cadastrarHorario(String email, String horario, String dia) {

		if(email.trim().equals("") || email == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		
		if(horario.trim().equals("") || horario == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		
		if(dia.trim().equals("") || dia == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		
		if (!this.emailTutores.containsKey(email)) {
			throw new IllegalArgumentException("Erro no cadastrar horario: tutor nao cadastrado");
		}
		
		this.tutores.get(this.emailTutores.get(email)).cadastrarHorario(horario, dia);
	}	

	/**
	 * Método que recebe os parametros necessários, verifica a validade e realiza cadastro do local de atendimento de um tutor.
	 * @param email email do tutor
	 * @param local local de atendimento
	 */	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		
		if(email.trim().equals("") || email == null) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
		
		if(local.trim().equals("") || local == null) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		
		if (!this.emailTutores.containsKey(email)) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
		
		this.tutores.get(this.emailTutores.get(email)).cadastrarLocalDeAtendimento(local);
	}
	
	/**
	 * Método que verificia a disponibilidade de atendimento do tutor especificado por e-mail no horário e dia também especificados.
	 * @param email email do tutor
	 * @param horario horário de atendimento
	 * @param dia dia de atendimento
	 * @return Boolean representando a disponibilidade (true para disponível, false para indisponível) 
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		if(email.trim().equals("") || email == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		
		if(horario.trim().equals("") || horario == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		
		if(dia.trim().equals("") || dia == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		
		if (!this.emailTutores.containsKey(email)) {
			//throw new IllegalArgumentException("Erro no cadastrar horario: tutor nao cadastrado");
			return false;
		}
		
		return this.tutores.get(this.emailTutores.get(email)).consultaHorario(horario, dia); 
	}

	/**
	 * Método que verificia a disponibilidade de atendimento do tutor especificado por e-mail no local também especificado.
	 * @param email email do tutor
	 * @param local local de atendimento
	 * @return Boolean representando a disponibilidade (true para disponível, false para indisponível) 
	 */
	public boolean consultaLocal(String email, String local) {
		if(email.trim().equals("") || email == null) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
		
		if(local.trim().equals("") || local == null) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		
		if (!this.emailTutores.containsKey(email)) {
			//throw new IllegalArgumentException("Erro no cadastrar horario: tutor nao cadastrado");
			return false;
		}
		
		return this.tutores.get(this.emailTutores.get(email)).consultaLocal(local);
	}
}
