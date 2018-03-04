package projeto;

public abstract class Ajuda {
	private String matriculaAluno;
	protected String disciplina;
	protected String matriculaTutor;
	private boolean foiAvaliado;
	
	public Ajuda (String matriculaAluno, String disciplina,String matriculaTutor) {
		this.matriculaAluno = matriculaAluno;
		this.disciplina = disciplina;
		this.matriculaTutor = matriculaTutor;
		this.foiAvaliado = false;
	}

	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getMatriculaTutor() {
		return matriculaTutor;
	}

	public void setMatriculaTutor(String matriculaTutor) {
		this.matriculaTutor = matriculaTutor;
	}
	
	public abstract String pegarTutor();

	public boolean foiAvaliado() {
		return this.foiAvaliado;
	}
	
	public void avaliaAjuda() {
		this.foiAvaliado = true;
	}

}
