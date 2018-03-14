package qma;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ajuda.Ajuda;
import ajuda.AjudaOnline;
import ajuda.AjudaPresencial;

public class AjudaController {
	
	private List<Ajuda> ajudas;
	
	public AjudaController() {
		this.ajudas = new ArrayList<Ajuda>();
	}
	
	/**
	 * Método que realiza o cadastro de uma ajuda presencial.
	 * 
	 * @param matrAluno matricula do aluno requisitando a ajuda
	 * @param disciplina disciplina de desejo de ajuda
	 * @param horario horario de atendimento para a ajuda
	 * @param dia dia de atendimento para a ajuda
	 * @param localInteresse local de atendimento da ajuda
	 * @return Inteiro com o ID da ajuda
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse, String matrTutor) {
		if (matrAluno.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
		if (horario.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
		if (dia.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
		if (localInteresse.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
		ajudas.add(new AjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse, matrTutor));
		return ajudas.size();

	}

	/**
	 * Método que realiza o cadastro de uma ajuda oline.
	 * 
	 * @param matrAluno matricula do aluno requisitando a ajuda.
	 * @param disciplina disciplina de desejo de ajuda.
	 * @return Inteiro com o ID da ajuda
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina, String matrTutor) {
		if (matrAluno.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
		AjudaOnline ajuda = new AjudaOnline(matrAluno, disciplina, matrTutor);
		ajudas.add(ajuda);
		return ajudas.size();
	}
	
	/**
	 * Método que retorna o tutor responsável por determinada ajuda, identificada por seu id.
	 * 
	 * @param idAjuda identificador da ajuda de interesse.
	 * @return String com as informações da ajuda especificada e do tutor referente a mesma
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
	 * @param idAjuda o identificador da ajuda de interesse.
	 * @param atributo o atributo que se quer recuperar da ajuda.
	 * @return String com o atributo desejado
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		if (idAjuda < 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
		if (idAjuda > ajudas.size()) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		}
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}

		return this.ajudas.get(idAjuda - 1).getInfoAjuda(atributo);
	}
	
	/**
	 * Método que avalia uma ajuda.
	 * 
	 * @param idAjuda o identificador da ajuda de interesse.
	 * @return String com a matrícula do tutor responsável pela ajuda avaliada.
	 */
	public String avaliaAjuda(int idAjuda) {
		if (idAjuda < 0) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: id nao pode menor que zero ");
		}
		if (idAjuda > ajudas.size()) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: id nao encontrado ");
		}
		if (this.ajudas.get(idAjuda - 1).foiAvaliado()) {
			throw new IllegalStateException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}
		this.ajudas.get(idAjuda - 1).avaliaAjuda();
		return this.ajudas.get(idAjuda - 1).getMatriculaTutor();
	}
	
	/**
	 * Método que recupera a informação de uma ajuda já ter sido avaliada ou não.
	 * 
	 * @param idAjuda o identificador da ajuda de interesse.
	 * @return Boolean indicando se a ajuda já foi avaliada ou não.
	 */
	public boolean foiAvaliado(int idAjuda) {
		return this.ajudas.get(idAjuda - 1).foiAvaliado();
	}
	
	/**
	 * Método que salva em arquivo as ajudas cadastradas até o momento.
	 */
	public void salvar() throws IOException {
		FileOutputStream fos;
		ObjectOutputStream oos;
		fos = new FileOutputStream(new File("ajudas.dat"));
		oos = new ObjectOutputStream(fos);
		oos.writeObject(this.ajudas);
		oos.close();

	}
	
	/**
	 * Método que carrega as ajudas salvas em um arquivo para o programa.
	 */
	public void carregar() throws IOException, ClassNotFoundException {
		FileInputStream fis;
		ObjectInputStream ois;
		fis = new FileInputStream(new File("ajudas.dat"));
		ois = new ObjectInputStream(fis);
		this.ajudas = (List<Ajuda>) ois.readObject();
		ois.close();
	}
	
	/**
	 * Método que limpa os dados existentes das ajudas até então cadastradas.
	 */
	public void limpar() {
		this.ajudas.clear();
	}
}
