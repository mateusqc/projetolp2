package projeto;

/**
 * Classe que representa um Aluno no sistema QUEM ME AJUDA.
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 *
 */
public class Aluno {

	/**
	 * Matrícula do Aluno.
	 */
	private String matricula;
	/**
	 * Nome do Aluno.
	 */
	private String nome;
	/**
	 * Código do curso do Aluno.
	 */
	private int codigoCurso;
	/**
	 * Telefone do Aluno - Atributo opicional.
	 */
	private String telefone;
	/**
	 * E-mail do Aluno.
	 */
	private String email;
	/**
	 * Array de notas de avaliação do Aluno.
	 * A média será sempre calculada.
	 */
	private double[] notaAvaliacao;
	/**
	 * Função do Aluno - Apenas para tutor, há melhor solução?
	 */
	private Funcao funcao;
	
	/**
	 * Construtor completo (com telefone) de Aluno. 
	 * @param nome
	 * @param matricula
	 * @param codigoCurso
	 * @param telefone
	 * @param email
	 */
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		
		this.verificaDados(nome, email);
		
		this.matricula = matricula;
		this.nome = nome;
		this.codigoCurso = codigoCurso;
		if(telefone == null || telefone.trim().equals("")) {
			this.telefone = "";
		}else {
			this.telefone = telefone;
		}
		this.email = email;
		this.notaAvaliacao = new double[] {5.0};
		this.funcao = new Estudante();
		
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
		
		for(int i = 0; i < emailParcionado.length; i++) {
			if(emailParcionado[i].trim() == "") {
				throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
			}
		}
	}
	
	/**
	 * Método que calcula a média das avaliações do Aluno.
	 * @return double com o valor da média
	 */
	private double calculaMediaAvaliacao() {
		double soma = 0;
		for (int i = 0; i < this.notaAvaliacao.length; i++) {
			soma += this.notaAvaliacao[i];
		}
		return soma/this.notaAvaliacao.length;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	/**
	 * Retorna o valor da média das avaliações do Aluno.
	 * @return double com o valor da média
	 */
	public double getNotaAvaliacao() {
		return this.calculaMediaAvaliacao();
	}
	
	/**
	 * Método que retorna uma representação em String das informações do Aluno, seguindo o seguinte padrão: 
	 * matricula - nome - codigoCurso - telefone (caso tenha sido informado) - email
	 * @return String com as informações do Aluno
	 */
	@Override
	public String toString() {
		if(telefone == "") {
			return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email;
		}
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " +  this.telefone + " - " + this.email;

	}
	
	public void tornaTutor(String disciplina, int proficiencia) {
		this.funcao = new Tutor(disciplina, proficiencia);
	}
	
}
