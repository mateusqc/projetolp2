package projeto;

import easyaccept.EasyAccept;

public class Facade {

	public AlunoController alunoController = new AlunoController();
	
	public static void main(String[] args) {

		args = new String[] { "projeto.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt"};
		EasyAccept.main(args);

	}

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		alunoController.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String recuperaAluno(String matricula) {
		
		return alunoController.recuperaAluno(matricula);
		
	}
	
	public String listarAlunos() {
		
		return alunoController.listarAlunos();
		
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		
		return alunoController.getInfoAluno(matricula, atributo);
		
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		
		alunoController.tornarTutor(matricula, disciplina, proficiencia);
		
	}
	
	public String recuperaTutor(String matricula) {
		
		return alunoController.recuperaTutor(matricula);
		
	}
	
	public String listarTutores() {
		
		return alunoController.listarTutores();

	}
}