package projeto;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AlunoTest {

	private Aluno aluno, alunoDois;
	private AlunoController controller;

	
	@Before

	public void setUp(){
		aluno = new Aluno("vitor", "00000", 12345, "3321-5489", "vitor@ccc.ufcg.edu.br");
		
	}
	
	@Test
	public void testConstrutorComDadosValidos() {
		Assert.assertEquals("vitor", aluno.getNome());
		Assert.assertEquals("00000", aluno.getMatricula());
		Assert.assertEquals(12345, aluno.getCodigoCurso());
		Assert.assertEquals("3321-5489", aluno.getTelefone());
		Assert.assertEquals("vitor@ccc.ufcg.edu.br", aluno.getEmail());
		
	}
	@Test
	
	public void testToString(){
		Assert.assertEquals("00000 - vitor - 12345 - 3321-5489 - vitor@ccc.ufcg.edu.br", aluno.toString());
	}
	

	}
	
	

