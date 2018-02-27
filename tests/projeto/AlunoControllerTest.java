package projeto;

import org.junit.Before;

import junit.framework.Assert;

public class AlunoControllerTest {
	
	private AlunoController alunoController;
	@Before
	
	public void setUp(){
		Aluno aluno = new Aluno("vitor", "00000", 12345, "3321-5489", "vitor@ccc.ufcg.edu.br");
		Aluno aluno2 = new Aluno("joeberth", "11111", 55555, "9989-9858", "joeberth@ccc.ufcg.edu.br");
	}
	
	public void cadastrarAlunoTest(){
		
	}
	
}
