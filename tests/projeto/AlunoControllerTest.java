package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de Testes para o {@link AlunoController}.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 *
 */
public class AlunoControllerTest {
	
	private AlunoController alunoController;
	
	/**
	 * Inicializa o controller para os testes.
	 */
	@Before
	public void inicializaController() {
		this.alunoController = new AlunoController();
	}
	
	/**
	 * Verifica o funcionamento do método no cadastro de um aluno válido. O cadastro deverá ocorrer sem problemas.
	 */
	@Test
	public void testCadastrarAlunoValido(){
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica o funcionamento do método no cadastro de um aluno com nome inválido. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoNomeInvalidoVazio() {
		this.alunoController.cadastrarAluno("  ", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica o funcionamento do método no cadastro de um aluno com nome nulo. Uma exceção do tipo {@link NullPointerException}
	 * deverá ser lançada.
	 */
	@Test(expected=NullPointerException.class)
	public void testCadastrarAlunoNomeInvalidoNulo() {
		this.alunoController.cadastrarAluno(null, "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica o funcionamento do método no cadastro de um aluno com e-mail inválido sem arroba. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoEmailInvalidoSemArroba() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunhaccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica o funcionamento do método no cadastro de um aluno com e-mail com arroba no começo. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoEmailInvalidoArrobaNoComeco() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "@mateus.cunhaccc.ufcg.edu.br");
	}
	
	/**
	 * Verifica o funcionamento do método no cadastro de um aluno com e-mail com arroba no final. Uma exceção do tipo {@link IllegalArgumentException}
	 * deverá ser lançada.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoEmailInvalidoArrobaNoFinal() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunhaccc.ufcg.edu.br@");
	}
	
	/**
	 * Verifica o funcionamento do método ao recuperar um aluno com matrícula válida. Deve funcionar sem problemas.
	 */
	@Test
	public void testRecuperaAlunoValido() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
		String esperado = "117110907 - Mateus Cunha - 45678 - mateus.cunha@ccc.ufcg.edu.br";
		assertEquals("o retorno do método deverá ser conforme o esperado", esperado, this.alunoController.recuperaAluno("117110907"));
	}
	
	/**
	 * Verifica o funcionamento do método ao recuperar um aluno com matrícula inválida inexistente no sistema. Deve ser lançada uma exceção
	 * do tipo {@link IllegalArgumentException}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testRecuperaAlunoInvalido() {
		this.alunoController.recuperaAluno("45645");
	}
	
	/**
	 * Verifica o funcionamento do método de listarAlunos, onde a listagem gerada deverá ser ordenada pelo nome.
	 */
	@Test
	public void testListarAlunos() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
		this.alunoController.cadastrarAluno("Lucas Cordeiro", "117456789", 45678, "", "lucas.brasil@ccc.ufcg.edu.br");
		String esperado = "117456789 - Lucas Cordeiro - 45678 - lucas.brasil@ccc.ufcg.edu.br, "
						+"117110907 - Mateus Cunha - 45678 - mateus.cunha@ccc.ufcg.edu.br";
		assertEquals("A listagem gerada deverá estar ordenada em ordem alfabética pelo nome e seguir o padrão esperado", esperado, this.alunoController.listarAlunos());						
	}
	
	/**
	 * Verifica o funcionamento do método getInfoAluno para parâmetros válidos e atributo nome. Deve retornar o nome do aluno.
	 */
	@Test
	public void testGetInfoAlunoMatriculaValidaNome() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
		assertEquals("O padrâmetro solicitado deverá ser informado", "Mateus Cunha", this.alunoController.getInfoAluno("117110907", "nome"));
	}
	
	/**
	 * Verifica o funcionamento do método getInfoAluno para parâmetros válidos e atributo telefone. Deve retornar o telefone do aluno ou vazio, caso o aluno não tenha.
	 */
	@Test
	public void testGetInfoAlunoMatriculaValidaTelefone() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
		assertEquals("O padrâmetro solicitado deverá ser informado", "", this.alunoController.getInfoAluno("117110907", "telefone"));
	}
	
	/**
	 * Verifica o funcionamento do método getInfoAluno para parâmetros válidos e atributo e-mail. Deve retornar o e-mail do aluno.
	 */
	@Test
	public void testGetInfoAlunoMatriculaValidaEmail() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
		assertEquals("O padrâmetro solicitado deverá ser informado", "mateus.cunha@ccc.ufcg.edu.br", this.alunoController.getInfoAluno("117110907", "email"));
	}
	
	/**
	 * Verifica o funcionamento do método getInfoAluno para matrícula inválida. Deve ser lançada uma exceção do tipo {@link IllegalArgumentException}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAlunoMatriculaInvalida() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
		assertEquals("O padrâmetro solicitado deverá ser informado", "mateus.cunha@ccc.ufcg.edu.br", this.alunoController.getInfoAluno("117110908", "email"));
	}
	
	/**
	 * Verifica o funcionamento do método getInfoAluno para nome de atributo inválido. Deve ser lançada uma exceção do tipo {@link IllegalArgumentException}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAlunoMatriculaValidaAtributoInvalido() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
		assertEquals("O padrâmetro solicitado deverá ser informado", "mateus.cunha@ccc.ufcg.edu.br", this.alunoController.getInfoAluno("117110907", "matricula"));
	}
	
	/**
	 * Verifica o funcionamento do método, que é um auxiliar na mudança de aluno para Tutor e retorna o Objeto Aluno correspondete à matrícula informada.
	 */
	@Test
	public void testTornaTutorValido() {
		this.alunoController.cadastrarAluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br");
		Aluno aluno = new Aluno("Mateus Cunha", "117110907", 45678, "", "mateus.cunha@ccc.ufcg.edu.br", 0);
		assertTrue("Deve ser retornado um objeto aluno correspondente ao aluno", aluno.equals(this.alunoController.getAluno("117110907")));
	}
	
	/**
	 * Verifica o funcionamento do método, que é um auxiliar na mudança de aluno para Tutor e retorna o Objeto Aluno correspondete à matrícula informada.
	 * Como o aluno com dada matrícula não existe, será lançada uma exceção do tipo {@link IllegalArgumentException}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTornaTutorInvalido() {
		this.alunoController.getAluno("117110907");
	}
}
