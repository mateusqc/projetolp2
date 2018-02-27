package projeto;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AlunoTest {

	private Aluno aluno, alunoDois;

	
	@Before
	public void setUp(){
		aluno = new Aluno("vitor", "00000", 12345, "3321-5489", "vitor@ccc.ufcg.edu.br");
		
	}
	
	@Test
	public void testCriaAlunoPassandoTelefone() {
		aluno = new Aluno("Lucas", "1000", 4000, "3335-1204", "lucas.brasil@ccc.ufcg.edu.br");
		assertEquals(aluno.toString(), "1000 - Lucas - 4000 - 3335-1204 - lucas.brasil@ccc.ufcg.edu.br");
	}
	
	@Test
	public void testToString(){
		Assert.assertEquals("00000 - vitor - 12345 - 3321-5489 - vitor@ccc.ufcg.edu.br", aluno.toString());
	}
	
	@Test
	public void testCriaAlunoSemPassarTelefone() {
		
		aluno = new Aluno("Lucas", "1000", 4000,"", "lucas.brasil@ccc.ufcg.edu.br");
		assertEquals(aluno.toString(), "1000 - Lucas - 4000 - lucas.brasil@ccc.ufcg.edu.br");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoNomeVazio() {
		
		aluno = new Aluno("  ", "1000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testCriaAlunoNomeNull() {
		
		aluno = new Aluno(null, "1000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoComEmailSemArroba() {
		
		aluno = new Aluno("Lucas", "1000", 4000, "", "lucas.brasil.ccc.ufcg.edu.br");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoComEmailInvalidoArrobaNoComeco() {
		
		aluno = new Aluno("Lucas", "1000", 4000, "", "@lucas.brasil.ccc.ufcg.edu.br");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoComEmailInvalidoArrobaNoFinal() {
		
		aluno = new Aluno("Lucas", "1000", 4000, "", "lucas.brasil.ccc.ufcg.edu.br@");
		
	}
	
	@Test
	public void testCompareToDeDoisAlunos() {
		
		alunoDois = new Aluno("Lucas", "1000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
		assert(aluno.compareTo(alunoDois) > 0);
		
	}
}
	

