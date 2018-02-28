package projeto;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de Testes JUnit para a classe {@link Aluno}.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 */
public class AlunoTest {
	/**
	 * Atributos do tipo Aluno que serão utilizados nos testes.
	 */
	private Aluno aluno, alunoDois;

	/**
	 * Criação padrão de Aluno para os testes.
	 */
	@Before
	public void setUp(){
		aluno = new Aluno("vitor", "00000", 12345, "3321-5489", "vitor@ccc.ufcg.edu.br");
		
	}
	
	/**
	 * Testa a criação de um aluno com telefone.
	 */
	@Test
	public void testCriaAlunoPassandoTelefone() {
		aluno = new Aluno("Lucas", "1000", 4000, "3335-1204", "lucas.brasil@ccc.ufcg.edu.br");
		assertEquals(aluno.toString(), "1000 - Lucas - 4000 - 3335-1204 - lucas.brasil@ccc.ufcg.edu.br");
	}
	
	/**
	 * Testa se o retorno do método toString está conforme o esperado.
	 */
	@Test
	public void testToString(){
		Assert.assertEquals("00000 - vitor - 12345 - 3321-5489 - vitor@ccc.ufcg.edu.br", aluno.toString());
	}
	
	/**
	 * Testa a criação de um aluno sem o parâmetro de telefone.
	 */
	@Test
	public void testCriaAlunoSemPassarTelefone() {
		aluno = new Aluno("Lucas", "1000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
		assertEquals(aluno.toString(), "1000 - Lucas - 4000 - lucas.brasil@ccc.ufcg.edu.br");
		
	}
	
	/**
	 * Verifica a criação de um aluno com nome vazio, deverá ser lançada uma exceção do tipo {@link IllegalArgumentException}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoNomeVazio() {
		aluno = new Aluno("  ", "1000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica a criação de um aluno com nome nulo, deverá ser lançada uma exceção do tipo {@link NullPointerException}.
	 */
	@Test(expected=NullPointerException.class)
	public void testCriaAlunoNomeNull() {
		
		aluno = new Aluno(null, "1000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
		
	}
	
	/**
	 * Verifica a criação de um aluno com e-mail sem arroba, deverá ser lançada uma exceção do tipo {@link IllegalArgumentException}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoComEmailSemArroba() {
		aluno = new Aluno("Lucas", "1000", 4000, "", "lucas.brasil.ccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica a criação de um aluno com e-mail com arroba no início, deverá ser lançada uma exceção do tipo {@link IllegalArgumentException}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoComEmailInvalidoArrobaNoComeco() {
		aluno = new Aluno("Lucas", "1000", 4000, "", "@lucas.brasil.ccc.ufcg.edu.br");	
	}
	
	/**
	 * Verifica a criação de um aluno com e-mail com arroba no final, deverá ser lançada uma exceção do tipo {@link IllegalArgumentException}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoComEmailInvalidoArrobaNoFinal() {
		aluno = new Aluno("Lucas", "1000", 4000, "", "lucas.brasil.ccc.ufcg.edu.br@");
	}
	
	/**
	 * Verifica o funcionamento do método {@link Aluno#compareTo(Aluno)}. Como aluno é maior que o alunoDois (vem depois na ordem alfabética)
	 * o retorno do método será positivo.
	 */
	@Test
	public void testCompareToDeDoisAlunosPositivo() {
		alunoDois = new Aluno("Lucas", "1000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
		assert(aluno.compareTo(alunoDois) > 0);
		
	}
	
	/**
	 * Verifica o funcionamento do método {@link Aluno#compareTo(Aluno)}. Como alunoDois é menor que o aluno (vem antes na ordem alfabética)
	 * o retorno do método será negativo.
	 */
	@Test
	public void testCompareToDeDoisAlunosNegativo() {
		alunoDois = new Aluno("Lucas", "1000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
		assert(alunoDois.compareTo(aluno) < 0);
	}
	
	/**
	 * Verifica o funcionamento do método {@link Aluno#equals(Object)}. Alunos com matrículas iguais devem ser considerados iguais.
	 */
	@Test
	public void testEqualsTrue() {
		alunoDois = new Aluno("Lucas", "00000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
		assertTrue("Alunos com matrículas iguais devem ser iguais", aluno.equals(alunoDois));
	}
	
	/**
	 * Verifica o funcionamento do método {@link Aluno#equals(Object)}. Alunos com matrículas diferentes devem ser considerados diferentes.
	 */
	@Test
	public void testEqualsFalse() {
		alunoDois = new Aluno("Lucas", "10000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
		assertFalse("Alunos com matrículas iguais devem ser iguais", aluno.equals(alunoDois));
	}
	
	/**
	 * Verifica o funcionamento do método {@link Aluno#hashCode()}. Alunos iguais devem ter um mesmo valor de hashCode.
	 */
	@Test
	public void testHashCode() {
		alunoDois = new Aluno("Lucas", "00000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br");
		assertTrue("Alunos iguais devem ter um mesmo valor de hashCode", aluno.hashCode() == alunoDois.hashCode());
	}
	
	/**
	 * Verifica o funcionamento do método {@link Aluno#getNotaAvaliacao()}. Como nenhuma nota foi adicionada, deverá ser exibida a nota padrão que é 5.0.
	 */
	@Test
	public void testGetNotaAvaliacao() {
		assertTrue("Como nenhuma nota foi adicionada, deve ser 5", aluno.getNotaAvaliacao() == 5.0);
	}
}
	

