package projeto;

public class Aluno {

	private String matricula;
	private String nome;
	private int codigoCurso;
	private String telefone;
	private String email;
	private double notaAvaliacao;
	private Funcao funcao;
	
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
		this.notaAvaliacao = 5;
		this.funcao = new Estudante();
		
	}
	
	public void verificaDados(String nome, String email) {
		
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
			
			if(emailParcionado[i] == null) {
				
				throw new IllegalArgumentException();
				
			}
			
		}
		
	}
	@Override
	public String toString() {
		if(telefone == "") {
			
			return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email;
			
		}
		
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " +  this.telefone + " - " + this.email;

	}
	
	public String getMatricula() {
		
		return this.matricula;
		
	}
	
	public String getNome() {
		
		return this.nome;
	
	}
	
	public int getCodigoCurso() {
		
		return this.codigoCurso;
		
	}
	
	public String getTelefone() {
		
		return this.telefone;
		
	}
	
	public String getEmail() {
		
		return this.email;
		
	}
	
	public void tornaTutor(String disciplina, int proficiencia) {
		
		this.funcao = new Tutor(disciplina, proficiencia);
		
	}
	
}
