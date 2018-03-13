package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.Aluno;
import projeto.Tutor;

/**
 * Classe de Testes JUnit para a classe {@link Tutor}.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 */
public class TutorTest {

	/**
	 * Atributos do tipo Tutor que serão utilizados nos testes.
	 */
	private Tutor tutorUm;
	private Tutor tutorDois;
	/**
	 * Atributo do tipo Aluno que serão utilizados nos testes.
	 */
	private Aluno aluno;
	private Aluno alunoDois;
	
	/**
	 * Criação padrão de Aluno e Tutor para os testes.
	 */
	@Before
	public void testCriaTutor() {
		aluno = new Aluno("Lucas", "1000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br", 0);
		tutorUm = new Tutor("Programação 2", 4, aluno);
		assertEquals(tutorUm.toString(), "1000 - Lucas - 4000 - lucas.brasil@ccc.ufcg.edu.br");
	}
	
	/**
	 * Testa o adicinamento de uma disciplina de tutoria ao tutor.
	 */
	@Test
	public void testAdicionaDisciplinaAoTutor() {
		
		tutorUm.adicionarDisciplina("Teoria dos Grafos", 5);
	
	}
	
	/**
	 * Verifica o adicinamento de uma disciplina da qual o tutor já realiza tutoria,deverá ser lançada uma exceção do tipo {@link IllegalArgumentException}. 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaDisciplinaJaCadastradaComoTutor() {
		
		tutorUm.adicionarDisciplina("Programação 2", 5);
		
	}
	
	/**
	 * Testa a obtenção da nota de avaliação do tutor.
	 */
	@Test
	public void testPegarNotaDeAvaliacaoDoTutor() {
		
		assert(tutorUm.getNotaAvaliacao() == 4);
		
	}
	
	/**
	 * Verifica o funcionamento do método {@link Tutor#hashCode()}. Tutores iguais devem ter um mesmo valor de hashCode.
	 */
	@Test
	public void testHashCode() {
		tutorDois = new Tutor("Teoria dos Grafos", 5, aluno);
		assertTrue("Tutores iguais devem ter um mesmo valor de hashCode", tutorUm.hashCode() == tutorDois.hashCode());
	}
	
	/**
	 * Verifica o funcionamento do método {@link Tutor#equals(Object)}. Tutores com matrículas iguais devem ser considerados iguais.
	 */
	@Test
	public void testEqualsTrue() {
		tutorDois = new Tutor("Teoria dos Grafos", 5, aluno);
		assertTrue("Tutores que são alunos que possuem matriculas iguais devem ser iguais", tutorUm.equals(tutorDois));
	}
	
	/**
	 * Verifica o funcionamento do método {@link Tutor#equals(Object)}. Tutores com matrículas diferentes devem ser considerados diferentes.
	 */
	@Test
	public void testEqualsFalse() {
		alunoDois = new Aluno("Mateus", "2000", 5000, "", "mateus@ccc.ufcg.edu.br", 1);
		tutorDois = new Tutor("Teoria dos Grafos", 5, alunoDois);
		assertFalse("Tutores que são alunos que possuem matriculas diferentes devem ser diferentes", tutorUm.equals(tutorDois));
		
	}
	
	/**
	 * Verifica o funcionamento do método {@link Tutor#compareTo(Tutor)}. Como tutorUm é maior que o tutorDois (vem depois na ordem alfabética)
	 * o retorno do método será positivo.
	 */
	@Test
	public void testCompareToDeDoisAlunosPositivo() {
		alunoDois = new Aluno("Jose", "1000", 4000, "", "jose@ccc.ufcg.edu.br", 1);
		tutorDois = new Tutor("Grafos", 5, alunoDois);
		assert(tutorUm.compareTo(tutorDois) > 0);
		
	}
	
	/**
	 * Verifica o funcionamento do método {@link Tutor#compareTo(Tutor)}. Como tutorDois é menor que o tutorUm (vem antes na ordem alfabética)
	 * o retorno do método será negativo.
	 */
	@Test
	public void testCompareToDeDoisAlunosNegativo() {
		alunoDois = new Aluno("Jose", "1000", 4000, "", "jose@ccc.ufcg.edu.br", 1);
		tutorDois = new Tutor("Grafos", 5, alunoDois);
		assert(tutorDois.compareTo(tutorUm) < 0);
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar o nível do tutor, com nota de avaliação suficiente para ser nível Tutor. Deve funcionar sem problemas.
	 */
	@Test
	public void testPegarNivelTutor() {
		assertEquals(tutorUm.pegarNivel(), "Tutor");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar o nível do tutor, com nota de avaliação suficiente para ser nível TOP. Deve funcionar sem problemas.
	 */
	@Test
	public void testPegarNivelTop() {
		tutorUm.avaliarTutor(5);
		tutorUm.avaliarTutor(5);
		tutorUm.avaliarTutor(5);
		tutorUm.avaliarTutor(5);
		assertEquals(tutorUm.pegarNivel(), "TOP");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar o nível do tutor, com nota de avaliação suficiente para ser nível Aprendiz. Deve funcionar sem problemas.
	 */
	@Test
	public void testPegarNivelAprendiz() {
		tutorUm.avaliarTutor(0);
		tutorUm.avaliarTutor(0);
		assertEquals(tutorUm.pegarNivel(), "Aprendiz");

	}
	
	/**
	 * Verifica o funcionamento do método do tutor de receber dinheiro. Deve funcionar sem problemas.
	 */
	@Test
	public void testRecebeDinheiro() {
		tutorUm.recebeDinheiro(100);
		assertTrue(tutorUm.totalDinheiroTutor() == 100);
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar a nota de avaliação do tutor. Deve funcionar sem problemas.
	 */
	@Test
	public void testGetNotaAvaliacao() {
		assertTrue(tutorUm.getNotaAvaliacao() == 4);
	}

}