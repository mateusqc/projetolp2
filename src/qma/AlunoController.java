package qma;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparadores.ComparaEmail;
import comparadores.ComparaNome;

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
	private Comparator comparador;
	
	/**
	 * Construtor do controller, onde é inicializado o Mapa de Alunos e o comparador padrão de ordenação.
	 */
	public AlunoController() {
		this.alunos = new HashMap<String, Aluno>();
		this.comparador = new ComparaNome();
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
		alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email, this.alunos.size() + 1));
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
		List<Aluno> alunosSort = new ArrayList<Aluno>(); 
		alunosSort.addAll(alunos.values());
		Collections.sort(alunosSort, this.comparador);
		
		String alunosListados = "";
		for(int i = 0; i < alunosSort.size(); i++) {
			alunosListados += alunosSort.get(i).toString();
			if(i != alunosSort.size() - 1) {
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
	 * Método que configura a ordem de listagem dos alunos, por ordem de email, nome ou matrícula.
	 * @param atributo atributo que indica qual tipo de ordem deve ser seguida.
	 */
	public void configurarOrdem(String atributo) {
		if(atributo.equals("EMAIL")) {
			this.comparador = new ComparaEmail();
		}
		if(atributo.equals("NOME")) {
			this.comparador = new ComparaNome();
		}
		if(atributo.equals("MATRICULA")) {
			this.comparador = null;
		}
	}
		
	/**
	 * Método auxiliar que retorna um Aluno cadastrado no sistema, verificando a presença do mesmo e retornando-o.
	 * @param matricula matrícula do Aluno
	 * @return Objeto do tipo {@link Aluno} referente à matrícula informada
	 */
	public Aluno getAluno(String matricula) {
		if(!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Aluno nao encontrado");
		}
		return this.alunos.get(matricula);
	}
	
	/**
	 * Método que salva em arquivo os alunos cadastradas até o momento.
	 */
	public void salvar() throws IOException {
		FileOutputStream fos;
		ObjectOutputStream oos;
		fos = new FileOutputStream(new File("alunos.dat"));
		oos = new ObjectOutputStream(fos);
		oos.writeObject(this.alunos);
		oos.close();

	}
	
	/**
	 * Método que carrega os alunos salvos em um arquivo para o programa.
	 */
	public void carregar() throws IOException, ClassNotFoundException {
		FileInputStream fis;
		ObjectInputStream ois;
		fis = new FileInputStream(new File("alunos.dat"));
		ois = new ObjectInputStream(fis);
		this.alunos = (Map<String, Aluno>) ois.readObject();
		ois.close();
	}
	
	/**
	 * Método que limpa os dados existentes dos alunos até então cadastrados.
	 */
	public void limpar() {
		this.alunos.clear();
	}
}