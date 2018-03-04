package projeto;

public class AjudaPresencial extends Ajuda {

	private String horario;
	private String dia;
	private String localInteresse;

	public AjudaPresencial(String matriculaAluno, String disciplina, String horario, String dia, String localInteresse,
			String matriculaTutor) {
		super(matriculaAluno, disciplina, matriculaTutor);

		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;

	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getLocalInteresse() {
		return localInteresse;
	}

	public void setLocalInteresse(String localInteresse) {
		this.localInteresse = localInteresse;
	}

}
