package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de Testes para o {@link TutorController}.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 *
 */
public class TutorControllerTest {

	private TutorController tutorController;
	private Aluno alunoUm;
	private Aluno alunoDois;
	private Aluno alunoTres;
	
	/**
	 * Inicializa o controller para os testes.
	 */
	@Before
	public void testInicializaTutorController() {
		
		tutorController = new TutorController();
		alunoUm = new Aluno("Lucas", "2000", 4000, "", "lucas.brasil@ccc.ufcg.edu.br", 0);
		alunoDois = new Aluno("Mateus", "3000", 4000, "", "mateus@ccc.ufcg.edu.br", 1);
		
	}
	
	/**
	 * Verifica o funcionamento do método de tornar um aluno tutor. Deve ocorrer sem problemas.
	 */
	@Test
	public void testTornarTutor() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		assertEquals(tutorController.recuperaTutor("2000"), "2000 - Lucas - 4000 - lucas.brasil@ccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica o funcionamento do método de tornar um aluno tutor com proficiência menor que um.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTornarTutorProficienciaMenorQueUm() {
		tutorController.tornarTutor("2000", "P2", 0, alunoUm);
		
	}
	
	/**
	 * Verifica o funcionamento do método de tornar um aluno tutor com proficiência maior que 5. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTornarTutorProficienciaMaiorQueCinco() {
		tutorController.tornarTutor("2000", "P2", 6, alunoUm);
		
	}
	
	/**
	 * Verifica o funcionamento do método de listarTutores, onde a listagem gerada deverá ser ordenada pelo nome.
	 */
	@Test
	public void testListarTutores() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.tornarTutor("3000", "P2", 5, alunoDois);
		assertEquals(tutorController.listarTutores(), "2000 - Lucas - 4000 - lucas.brasil@ccc.ufcg.edu.br, 3000 - Mateus - 4000 - mateus@ccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um horário de atendimento de um tutor. Deve ocorrer sem problemas.
	 */
	@Test
	public void testCadastrarHorario() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui");
		assertTrue(tutorController.consultaHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui"));
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um horário de atendimento de um tutor, passando um email vazio. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarHorarioEmailVazio() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.cadastrarHorario("  ", "14:00", "qui");
		
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um horário de atendimento de um tutor, passando um email nulo. Uma exceção do tipo {@link NullPointerException}
	 * deverá ser lançada.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastrarHorarioEmailNull() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.cadastrarHorario(null, "14:00", "qui");
		
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um horário de atendimento de um tutor, passando um horario vazio. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarHorarioComHorarioVazio() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "  ", "qui");
		
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um horário de atendimento de um tutor, passando um horario nulo. Uma exceção do tipo {@link NullPointerException}
	 * deverá ser lançada.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastrarHorarioComHorarioNull() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", null, "qui");
		
	}

	/**
	 * Verifica o funcionamento do método de cadastrar um horário de atendimento de um tutor, passando um dia de atendimento vazio. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarHorarioDiaVazio() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "  ");
		
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um horário de atendimento de um tutor, passando um dia de atendimento nulo. Uma exceção do tipo {@link NullPointerException}
	 * deverá ser lançada.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastrarHorarioDiaNull() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", null);
		
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um local de atendimento de um tutor. Deve funcionar sem problemas.
	 */
	@Test
	public void testCadastraLocalDeAtendimento() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "UFCG");
		assertTrue(tutorController.consultaLocal("lucas.brasil@ccc.ufcg.edu.br", "UFCG"));
		
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um local de atendimento de um tutor, passando um email vazio. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraLocalDeAtendimentoEmailVazio() {
		tutorController.tornarTutor("2000", "P2",5, alunoUm);
		tutorController.cadastrarLocalDeAtendimento("  ", "UFCG");
		
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um local de atendimento de um tutor, passando um email nulo. Uma exceção do tipo {@link NullPointerException}
	 * deverá ser lançada.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraLocalDeAtendimentoEmailNull() {
		
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.cadastrarLocalDeAtendimento(null, "UFCG");
		
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um local de atendimento de um tutor, passando um local vazio. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastraLocalDeAtendimentoLocalVazio() {
		tutorController.tornarTutor("2000", "P2",5, alunoUm);
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "  ");
		
	}
	
	/**
	 * Verifica o funcionamento do método de cadastrar um local de atendimento de um tutor, passando um local nulo. Uma exceção do tipo {@link NullPointerException}
	 * deverá ser lançada.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastraLocalDeAtendimentoLocasNull() {
		
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", null);
		
	}

	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial. Deve funcionar sem problemas.
	 */
	@Test
	public void testPedirAjudaPresencial() {
		this.alunoTres = new Aluno("Daniel", "4000", 4000, "", "daniel@ccc.ufcg.edu.br", 2);
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.tornarTutor("4000", "P2", 4, alunoTres);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui");
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "UFCG");
		tutorController.pedirAjudaPresencial("3000","P2", "14:00", "qui", "UFCG");
		assertEquals(this.tutorController.pegarTutor(1), "Tutor - 2000, horario - 14:00, dia - qui, local - UFCG, disciplina - P2");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda online. Deve funcionar sem problemas.
	 */
	@Test
	public void testPedirAjudaOnline() {
		this.alunoTres = new Aluno("Daniel", "4000", 4000, "", "daniel@ccc.ufcg.edu.br", 2);
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.tornarTutor("4000", "LP2", 4, alunoTres);
		tutorController.pedirAjudaOnline("3000","LP2");
		assertEquals(this.tutorController.pegarTutor(1), "Tutor - 2000, disciplina - LP2");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando uma matrícula de aluno vazia.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatriculaAlunoVazia() {
		
		tutorController.pedirAjudaPresencial(" ", "P2", "14:00", "qui", "UFCG");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando uma disciplina vazia.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaVazia() {
		
		tutorController.pedirAjudaPresencial(" ", "P2", "14:00", "qui", "UFCG");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando um horario vazio.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioVazio() {
		
		tutorController.pedirAjudaPresencial(" ", "P2", "14:00", "qui", "UFCG");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando um dia vazio.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaVazio() {
		
		tutorController.pedirAjudaPresencial(" ", "P2", "14:00", "qui", "UFCG");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando um local de atendimento vazio.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalDeAtendimentoVazio() {
		
		tutorController.pedirAjudaPresencial(" ", "P2", "14:00", "qui", "UFCG");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda online, passando uma matrícula de aluno vazia.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatriculaAlunoVazia() {
		
		tutorController.pedirAjudaOnline("  ", "P2");
	}
	
	/**
	 * Verifica o funcionamento do método de realizar um pedido de ajuda presencial, passando uma disciplina vazia.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaVazia() {
		
		tutorController.pedirAjudaOnline("3000", "  ");
	}
	
	/**
	 * Verifica o funcionamento do método de pegar o tutor de ajuda, passando um identificador de ajuda menor que zero.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPegarTutorIdMenorQueZero() {
		
		tutorController.pegarTutor(-1);
		
	}
	
	/**
	 * Verifica o funcionamento do método de pegar o tutor de ajuda, passando um identificador de ajuda não cadastrado.Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPegarTutorIdNaoCadastrado() {
		
		tutorController.pegarTutor(4);
		
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda online. Deve funcionar sem problemas.
	 */
	@Test
	public void testGetInfoAjudaOnline() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		assertEquals(tutorController.getInfoAjuda(1, "disciplina"), "LP2");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda online, passando um atributo vazio. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoVazio() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.getInfoAjuda(1, "   ");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda online, passando um atributo invalido. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoInvalido() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.getInfoAjuda(1, "nome");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda online, passando um identificador de ajuda menor que zero. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineIdAjudaMenorQueZero() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.getInfoAjuda(-1, "   ");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda online, passando um identificador de ajuda não cadastrado. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineIdAjudaNaoCadastrado() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.getInfoAjuda(2, "disciplina");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando um atributo vazio. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test
	public void testGetInfoAjudaPresencialDisciplina() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui");
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "UFCG");
		tutorController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG");
		assertEquals(tutorController.getInfoAjuda(1, "disciplina"), "LP2");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando o atributo como "horario". Deve funcionar sem problemas.
	 */
	@Test
	public void testGetInfoAjudaPresencialHorario() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui");
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "UFCG");
		tutorController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG");
		assertEquals(tutorController.getInfoAjuda(1, "horario"), "14:00");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando o atributo como "dia". Deve funcionar sem problemas.
	 */
	@Test
	public void testGetInfoAjudaPresencialDia() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui");
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "UFCG");
		tutorController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG");
		assertEquals(tutorController.getInfoAjuda(1, "dia"), "qui");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando o atributo como "localInteresse". Deve funcionar sem problemas.
	 */
	@Test
	public void testGetInfoAjudaPresencialLocalDeInteresse() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui");
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "UFCG");
		tutorController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG");
		assertEquals(tutorController.getInfoAjuda(1, "localInteresse"), "UFCG");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando o atributo como vazio. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoVazio() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui");
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "UFCG");
		tutorController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG");
		tutorController.getInfoAjuda(1, "  ");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda presencial, passando um atributo inválido. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoInvalido() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui");
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "UFCG");
		tutorController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG");
		tutorController.getInfoAjuda(1, "nome");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda, passando um identificador de ajuda menor que zero. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoIdAjudaMenorQueZero() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui");
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "UFCG");
		tutorController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG");
		tutorController.getInfoAjuda(-1, "disciplina");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar uma informação de uma ajuda, passando um identificador de ajuda não cadastrado. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialIdAjudaNaoCadastrado() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.cadastrarHorario("lucas.brasil@ccc.ufcg.edu.br", "14:00", "qui");
		tutorController.cadastrarLocalDeAtendimento("lucas.brasil@ccc.ufcg.edu.br", "UFCG");
		tutorController.pedirAjudaPresencial("3000","LP2", "14:00", "qui", "UFCG");
		tutorController.getInfoAjuda(3, "disciplina");
	}
	
	/**
	 * Verifica o funcionamento do método de avaliar um tutor por determinada ajuda. Deve funcionar sem problemas.
	 */
	@Test
	public void testAvaliarTutor() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.avaliarTutor(1, 5);
		assertEquals(tutorController.pegarNota("2000"), "4,17");
	}
	
	/**
	 * Verifica o funcionamento do método de avaliar tutor por determinada ajuda, passando como parâmetro uma nota menor que zero. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAvaliarTutorNotaMenorQueZero() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.avaliarTutor(1, -1);
		
	}
	
	/**
	 * Verifica o funcionamento do método de avaliar tutor por determinada ajuda, passando como parâmetro uma nota maior que cinco. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAvaliarTutorNotaMaiorQueCinco() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.avaliarTutor(1, 6);
	}
	
	/**
	 * Verifica o funcionamento do método de avaliar tutor por determinada ajuda, passando como parâmetro uma identificação de ajuda negativa. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAvaliarTutorIdAjudaNegativo() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.avaliarTutor(-1, 5);
	}
	
	/**
	 * Verifica o funcionamento do método de avaliar tutor por determinada ajuda, passando como parâmetro uma identificação não cadastrada. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAvaliarTutorIdAjudaNaoCadastrado() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.avaliarTutor(3, 5);
	}
	
	/**
	 * Verifica o funcionamento do método de avaliar tutor por determinada ajuda, passando como parâmetro uma nota maior que cinco. Uma exceção do tipo {@link NullPointerException}
	 * deverá ser lançada.
	 */
	@Test(expected=NullPointerException.class)
	public void testPegarNotaMatriculaNaoCadastradaComoTutor() {
		tutorController.pegarNota("1000");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar o nível de determinado tutor. Deve funcionar sem problemas.
	 */
	@Test	
	public void testPegarNivel() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.avaliarTutor(1, 5);
		assertEquals(tutorController.pegarNivel("2000"), "Tutor");
	}
	
	/**
	 * Verifica o funcionamento do método de recuperar o nível de um tutor, passando como parâmetro uma matrícula não cadastrada.  Uma exceção do tipo {@link NullPointerException}
	 * deverá ser lançada.
	 */
	@Test(expected=NullPointerException.class)
	public void testPegarNivelMatriculaNaoCadastradaComoTutor() {
		tutorController.pegarNivel("1000");
	}
	
	/**
	 * Verifica o funcionamento do método doar para um tutor com nível Tutor. Deve funcionar sem problemas.
	 */
	@Test
	public void testDoarNivelTutor() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.doar("2000", 100);
		assertTrue(tutorController.totalDinheiroTutor("lucas.brasil@ccc.ufcg.edu.br") == 80);

	}
	
	/**
	 * Verifica o funcionamento do método doar para um tutor com nível Aprendiz. Deve funcionar sem problemas.
	 */
	@Test
	public void testDoarNivelAprendiz() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.pedirAjudaOnline("4000", "LP2");
		tutorController.avaliarTutor(1, 0);
		tutorController.avaliarTutor(2, 0);
		tutorController.doar("2000", 100);
		assertTrue(tutorController.totalDinheiroTutor("lucas.brasil@ccc.ufcg.edu.br") == 37);

	
	}
	
	/**
	 * Verifica o funcionamento do método doar para um tutor com nível Top. Deve funcionar sem problemas.
	 */
	@Test
	public void testDoarNivelTop() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.pedirAjudaOnline("4000", "LP2");
		tutorController.pedirAjudaOnline("3000", "P2");
		tutorController.pedirAjudaOnline("4000", "P2");
		tutorController.avaliarTutor(1, 5);
		tutorController.avaliarTutor(2, 5);
		tutorController.avaliarTutor(3, 5);
		tutorController.avaliarTutor(4, 5);
		tutorController.doar("2000", 100);
		assertTrue(tutorController.totalDinheiroTutor("lucas.brasil@ccc.ufcg.edu.br") == 90);

	
	}
	
	/**
	 * Verifica o funcionamento do método doar para um tutor, passando como parâmetro uma matrícula não cadastrada. Uma exceção do tipo {@link NullPointerException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testDoarParaTutorNaoCadastrado() {
		tutorController.doar("2000", 100);
	}

	/**
	 * Verifica o funcionamento do método de pegar o valor do caixa do sistema. Deve funcionar sem problemas.
	 */
	@Test
	public void testGetCaixaSistema() {
		tutorController.tornarTutor("2000", "LP2", 5, alunoUm);
		tutorController.pedirAjudaOnline("3000", "LP2");
		tutorController.doar("2000", 100);
		assertTrue(tutorController.getCaixaSistema() == 20);		
	}
	
	/**
	 * Verifica o funcionamento de configurar a ordem dos tutores por nome. Deve funcionar sem problemas.
	 */
	@Test
	public void testConfigurarOrdemNome() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.tornarTutor("3000", "LP2", 5, alunoDois);
		tutorController.configurarOrdem("NOME");
		assertEquals(tutorController.listarTutores(), "2000 - Lucas - 4000 - lucas.brasil@ccc.ufcg.edu.br, 3000 - Mateus - 4000 - mateus@ccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica o funcionamento de configurar a ordem dos tutores por email. Deve funcionar sem problemas.
	 */
	@Test
	public void testConfiguraOrdemEmail() {
		alunoTres = new Aluno("Jose", "1000", 4000, "", "marcos.jose@ccc.ufcg.edu.br", 2);
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.tornarTutor("3000", "LP2", 5, alunoDois);
		tutorController.tornarTutor("1000", "LP2", 5, alunoTres);
		tutorController.configurarOrdem("EMAIL");
		assertEquals(tutorController.listarTutores(), "2000 - Lucas - 4000 - lucas.brasil@ccc.ufcg.edu.br, 1000 - Jose - 4000 - marcos.jose@ccc.ufcg.edu.br, 3000 - Mateus - 4000 - mateus@ccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica o funcionamento de configurar a ordem dos tutores por matrícula. Deve funcionar sem problemas.
	 */
	@Test
	public void testConfiguraOrdemMatricula() {
		tutorController.tornarTutor("2000", "P2", 5, alunoUm);
		tutorController.tornarTutor("3000", "P2", 5, alunoDois);
		tutorController.configurarOrdem("MATRICULA");
		assertEquals(tutorController.listarTutores(), "2000 - Lucas - 4000 - lucas.brasil@ccc.ufcg.edu.br, 3000 - Mateus - 4000 - mateus@ccc.ufcg.edu.br");
	}

}
