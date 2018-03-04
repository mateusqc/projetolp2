package projeto;

public abstract class Ajuda {
	private String matriculaAluno;
	private String disciplina;
	private String matriculaTutor;
	
	public Ajuda (String matriculaAluno, String disciplina,String matriculaTutor) {
		this.matriculaAluno = matriculaAluno;
		this.disciplina = disciplina;
		this.matriculaTutor = matriculaTutor;
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

}
