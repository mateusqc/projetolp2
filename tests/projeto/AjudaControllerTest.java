package projeto;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import qma.AjudaController;
import qma.Aluno;
import qma.Tutor;

public class AjudaControllerTest {

	private AjudaController ajudaController;
	private Tutor tutorTeste;
	
	/**
	 * Inicializa o controller para os testes, bem como um tutor de teste.
	 */
	@Before
	public void testCriaAjudaController() {
		ajudaController = new AjudaController();
		tutorTeste = new Tutor("LP2",5, new Aluno("Lucas", "2000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br", 1));
	}

	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial. Deve funcionar sem problemas.
	 */
	@Test
	public void testPedirAjudaPresencial() {
		ajudaController.pedirAjudaPresencial("3000","P2", "14:00", "qui", "UFCG", "2000");
		assertEquals(this.ajudaController.pegarTutor(1), "Tutor - 2000, horario - 14:00, dia - qui, local - UFCG, disciplina - P2");
	}
	

	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda online. Deve funcionar sem problemas.
	 */
	@Test
	public void testPedirAjudaOnline() {
		ajudaController.pedirAjudaOnline("3000","LP2", "2000");
		assertEquals(this.ajudaController.pegarTutor(1), "Tutor - 2000, disciplina - LP2");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando uma matrícula de aluno vazia.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatriculaAlunoVazia() {
		
		ajudaController.pedirAjudaPresencial(" ", "P2", "14:00", "qui", "UFCG", "2000");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando uma disciplina vazia.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaVazia() {
		
		ajudaController.pedirAjudaPresencial("3000", "  ", "14:00", "qui", "UFCG", "2000");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando um horario vazio.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioVazio() {
		
		ajudaController.pedirAjudaPresencial("3000", "P2", " ", "qui", "UFCG", "2000");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando um dia vazio.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaVazio() {
		
		ajudaController.pedirAjudaPresencial("3000", "P2", "14:00", " ", "UFCG", "2000");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando um local de atendimento vazio.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalDeAtendimentoVazio() {
		
		ajudaController.pedirAjudaPresencial("3000", "P2", "14:00", "qui", "  ", "2000");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda online, passando uma matrícula de aluno vazia.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatriculaAlunoVazia() {
		
		ajudaController.pedirAjudaOnline("  ", "P2", "2000");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda online, passando uma disciplina vazia.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaVazia() {
		
		ajudaController.pedirAjudaOnline("3000", "  ", "2000");
	}
	
	/**
	 * Verifica o funcionamento do método de pegar o tutor de ajuda, passando um identificador de ajuda menor que zero.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPegarTutorIdMenorQueZero() {
		
		ajudaController.pegarTutor(-1);
		
	}
	
	/**
	 * Verifica o funcionamento do método de pegar o tutor de ajuda, passando um identificador de ajuda não cadastrado.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPegarTutorIdNaoCadastrado() {
		
		ajudaController.pegarTutor(4);
		
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda online. Deve funcionar sem problemas.
	 */
	@Test
	public void testGetInfoAjudaOnline() {
		ajudaController.pedirAjudaOnline("3000", "LP2", "2000");
		assertEquals(ajudaController.getInfoAjuda(1, "disciplina"), "LP2");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda online, passando um atributo vazio. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoVazio() {
		ajudaController.pedirAjudaOnline("3000", "LP2", "2000");
		ajudaController.getInfoAjuda(1, "   ");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda online, passando um atributo invalido. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoInvalido() {
		ajudaController.pedirAjudaOnline("3000", "LP2", "2000");
		ajudaController.getInfoAjuda(1, "nome");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda online, passando um identificador de ajuda menor que zero. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineIdAjudaMenorQueZero() {
		ajudaController.pedirAjudaOnline("3000", "LP2", "2000");
		ajudaController.getInfoAjuda(-1, "   ");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda online, passando um identificador de ajuda não cadastrado. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineIdAjudaNaoCadastrado() {
		ajudaController.pedirAjudaOnline("3000", "LP2", "2000");
		ajudaController.getInfoAjuda(2, "disciplina");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial. Deve funcionar sem problemas.
	 */
	@Test
	public void testGetInfoAjudaPresencialDisciplina() {
		ajudaController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG", "2000");
		assertEquals(ajudaController.getInfoAjuda(1, "disciplina"), "LP2");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando o atributo como "horario". Deve funcionar sem problemas.
	 */
	@Test
	public void testGetInfoAjudaPresencialHorario() {
		ajudaController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG", "2000");
		assertEquals(ajudaController.getInfoAjuda(1, "horario"), "14:00");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando o atributo como "dia". Deve funcionar sem problemas.
	 */
	@Test
	public void testGetInfoAjudaPresencialDia() {
		ajudaController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG", "2000");
		assertEquals(ajudaController.getInfoAjuda(1, "dia"), "qui");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando o atributo como "localInteresse". Deve funcionar sem problemas.
	 */
	@Test
	public void testGetInfoAjudaPresencialLocalDeInteresse() {
		ajudaController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG", "2000");
		assertEquals(ajudaController.getInfoAjuda(1, "localInteresse"), "UFCG");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando o atributo como vazio. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoVazio() {
		ajudaController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG", "2000");
		ajudaController.getInfoAjuda(1, "  ");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando um atributo inválido. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoInvalido() {
		ajudaController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG", "2000");
		ajudaController.getInfoAjuda(1, "nome");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando um identificador de ajuda menor que zero. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoIdAjudaMenorQueZero() {
		ajudaController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG", "2000");
		ajudaController.getInfoAjuda(-1, "disciplina");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando um identificador de ajuda não cadastrado. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialIdAjudaNaoCadastrado() {
		ajudaController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG", "2000");
		ajudaController.getInfoAjuda(3, "disciplina");
	}
	
	/**
	 * Verifica o funcionamento do método de avaliar uma ajuda online. Deve funcionar sem problemas.
	 */
	@Test
	public void testAvaliarAjuda() {
		ajudaController.pedirAjudaOnline("3000", "LP2", "2000");
		ajudaController.avaliaAjuda(1);
		assertTrue(ajudaController.foiAvaliado(1));
	}
	
	/**
	 * Verifica o funcionamento do método de avaliar uma ajuda online, passando como parâmetro uma nota menor que zero. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAvaliarAjudaIdMenorQueZero() {
		ajudaController.pedirAjudaOnline("3000", "LP2", "2000");
		ajudaController.avaliaAjuda(-1);
		
	}
	
	/**
	 * Verifica o funcionamento do método de avaliar uma ajuda online, passando como parâmetro um id não cadastrado. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAvaliarAjudaIdNaoCadastrado() {
		ajudaController.pedirAjudaOnline("3000", "LP2", "2000");
		ajudaController.avaliaAjuda(4);
	}
	
}
