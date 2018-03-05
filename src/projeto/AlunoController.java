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
public class AlunoController {
	/**
	 * Mapa de Alunos, onde a chave é a matrícula do Aluno.
	 */
	private Map<String, Aluno> alunos;
	private int posicaoUltimoAluno;
	
	/**
	 * Construtor do controller, onde é inicializado o Mapa de Alunos.
	 */
	public AlunoController() {
		this.alunos = new HashMap<String, Aluno>();
		this.posicaoUltimoAluno = 0;
	}
		
	/**
	 * Método que cadastra um Aluno no sistema. Caso o Aluno já exista no sistema, uma exceção do tipo {@link IllegalArgumentException} será lançada. 
	 * @param nome nome do Aluno
	 * @param matricula matrícula do Aluno
	 * @param codigoCurso código do curso do Aluno
	 * @param telefone telefone do Aluno (opcional)
	 * @param email e-mail do Aluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.verificaDados(nome, email);
		if(alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email,posicaoUltimoAluno++));
	}
	
	/**
	 * Método que verifica a validade das Strings de nome e e-mail. Caso algum dos parâmetros esteja incorreto, será lançada uma exceção do tipo
	 * {@link IllegalArgumentException} ou {@link NullPointerException}.
	 * @param nome nome do Aluno
	 * @param email e-mail do Aluno
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
	
	/**
	 * Método que retona as informações de um Aluno com base na sua matrícula. A String retornada será a mesma de {@link Aluno#toString()}. Caso o Aluno não esteja cadastrado, será lançada uma exceção do tipo
	 * {@link IllegalArgumentException}.
	 * @param matricula matrícula do Aluno a ser buscado
	 * @return String com as informações do Aluno
	 */
	public String recuperaAluno(String matricula) {
		if(!alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por aluno: Aluno nao encontrado");
		}
		return alunos.get(matricula).toString();
		
	}
	
	/**
	 * Método que gera uma listagem ordenada por nome de todos os Alunos cadastrados no sistema.
	 * @return String listando todos os Alunos ordenados 
	 */
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
	
	/**
	 * Método que retorna uma informação específica a respeito do Aluno. O atributo desejado é passado como parâmetro.
	 * @param matricula matrícula do Aluno a ser consultado
	 * @param atributo atributo que será retornado
	 * @return String com o atributo solicitado
	 */
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
	
	/**
	 * Método auxiliar no papel de tornar o Aluno Tutor, verificando a presença do Aluno a ser transformado em Tutor no sistema e
	 * retornando o mesmo.
	 * @param matricula matrícula do Aluno
	 * @return Objeto do tipo {@link Aluno} referente à matrícula informada
	 */
	public Aluno tornarTutor(String matricula) {
		if(!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na definicao de papel: Tutor nao encontrado");
		}
		return this.alunos.get(matricula);
	}
}