package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe que representa o Controller de Alunos do QUEM ME AJUDA.
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 */
public class TutorController {
	private Map<String, Tutor> tutores;
	
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia, Aluno aluno) {
		if(proficiencia < 1 || proficiencia > 5) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
		if(!tutores.containsKey(matricula)) {
			this.tutores.put(matricula, new Tutor(disciplina, proficiencia, aluno));
		} else {
			this.tutores.get(matricula).adicionarDisciplina(disciplina, proficiencia);
		}
	}

	public String recuperaTutor(String matricula) {
		if(!tutores.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por tutor: Tutor nao encontrado");
		}
		
		return this.tutores.get(matricula).toString();
	
	}

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
	 * Método que recebe os parametros necessários, verifica a validade e realiza cadastro de horario de um tutor
	 * @param email
	 * @param horario
	 * @param dia
	 */
	public void cadastrarHorario(String email, String horario, String dia) {

		if(email.trim().equals("") || email == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		
		if(horario.trim().equals("") || horario == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		
		if(dia.trim().equals("") || horario == null) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		
		int ajuda = 0;
		for (Tutor tutor : this.tutores.values()) {
			
			if(tutor.getAluno().getEmail().equals(email)) {
				tutor.cadastrarHorario(horario, dia);
				ajuda += 1;
				break;
			} 
		} if(ajuda == 0) {
			throw new IllegalArgumentException("Erro no cadastrar horario: tutor nao cadastrado");
		}
	}	

	/**
	 * Método que recebe os parametros necessários, verifica a validade e realiza cadastro do local de atendimento de um tutor
	 * @param email
	 * @param local
	 */
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		
		if(email.trim().equals("") || email == null) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
		
		if(local.trim().equals("") || local == null) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		
		int ajuda = 0;
		for (Tutor tutor : this.tutores.values()) {
			if( tutor.getAluno().getEmail().equals(email)) {
				tutor.cadastrarLocalDeAtendimento(local);
				ajuda += 1;
				break;
			}
		}	if(ajuda ==0) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
	}
	
	/**
	 * Método que verifica se um determinado tutor possui o horario passado para verificação
	 * @param email
	 * @param horario
	 * @param dia
	 * @return
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		for (Tutor tutor : this.tutores.values()) {
			if( tutor.getAluno().getEmail().equals(email)) {
				System.out.println(tutor.getHorarios().contains(horario + " - " + dia));
				if(tutor.getHorarios().contains(horario + " - " + dia)) {
					return true;
				}
			} 
		} return false; 
	}

	/**
	 * Método que verifica se um determinado tutor possui o local passado para verificação
	 * @param email
	 * @param local
	 * @return
	 */
	public boolean consultaLocal(String email, String local) {
		for (Tutor tutor : this.tutores.values()) {
			if( tutor.getAluno().getEmail().equals(email)) {
				if(tutor.getLocais().contains(local)) {
					return true;
				} 	
			} 
		} return false;
	}
}
