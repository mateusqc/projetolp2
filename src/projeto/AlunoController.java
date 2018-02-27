package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe que representa o Controller de Alunos do QUEM ME AJUDA.
 * @author Lucas Cordeiro Brasil
 * @author Maeteus Queiroz Cunha
 *
 */
public class AlunoController {

	private Map<String, Aluno> alunos;
	
	public AlunoController() {
		this.alunos = new HashMap<String, Aluno>();
	}
		
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.verificaDados(nome, email);
		//verificar telefone?
		if(alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));
	}
	
	/**
	 * Método que verifica a validade das Strings de nome e e-mail.
	 * @param nome
	 * @param email
	 */
	private void verificaDados(String nome, String email) {
		if(nome == null) {
			throw new NullPointerException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		if(nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		if(!email.contains("@")) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}
		
		String[] emailParcionado = email.split("@");
		
		if (emailParcionado.length != 2) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}
		
		for(int i = 0; i < emailParcionado.length; i++) {
			if(emailParcionado[i].equals("")) {
				throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
			}
		}
	}
	
	public String recuperaAluno(String matricula) {
		if(!alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por aluno: Aluno nao encontrado");
		}
		return alunos.get(matricula).toString();
		
	}
	
	public String listarAlunos() {
		List<Aluno> alunosOrdenadosNome = new ArrayList<Aluno>();
		
		for(Aluno aluno : this.alunos.values()) {
			alunosOrdenadosNome.add(aluno);	
		}
		
		Collections.sort(alunosOrdenadosNome);
		
		String alunosListados = "";
		for(int i=0; i < alunosOrdenadosNome.size(); i++) {
			alunosListados += alunosOrdenadosNome.get(i).toString();
			if(i != alunosOrdenadosNome.size() - 1) {
				alunosListados += ", ";
			}
		}
		return alunosListados;
		
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		
		if(!alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: Aluno nao encontrado");
		}
		
		if(atributo.equalsIgnoreCase("nome")) {
			return alunos.get(matricula).getNome();
		}else if(atributo.equalsIgnoreCase("telefone")) {
			return alunos.get(matricula).getTelefone();
		}else if(atributo.equalsIgnoreCase("email")) {
			return alunos.get(matricula).getEmail();
		}else {
			throw new IllegalArgumentException();
		}
		
	}


	public Aluno tornarTutor(String matricula) {
		if(!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na definicao de papel: Tutor nao encontrado");
		}
		return this.alunos.get(matricula);
	}
	
}