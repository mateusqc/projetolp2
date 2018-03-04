package projeto;

public class AjudaOnline extends Ajuda {
	
	
	public AjudaOnline(String matriculaAluno, String disciplina,String matriculaTutor) {
	super(matriculaAluno,disciplina,matriculaTutor);
	}

	@Override
	public String pegarTutor() {
		return "Tutor - " + this.matriculaTutor + ", disciplina- " + this.disciplina;
	}

}
