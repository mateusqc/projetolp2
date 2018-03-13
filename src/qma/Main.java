package qma;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Facade facade = new Facade();
		/*
		facade.cadastrarAluno("Fulano de tal", "123456789", 123, "", "fulano.tal@ccc.ufcg.edu.br");
		facade.cadastrarAluno("Ciclano de tal", "789321456", 123, "", "ciclano.tal@ccc.ufcg.edu.br");
		facade.cadastrarAluno("Beltrano de tal", "987654321", 232, "3335-6486", "beltrano.tal@ccc.ufcg.edu.br");
		
		System.out.println(facade.listarAlunos() + System.lineSeparator());
		facade.tornarTutor("123456789", "LP2", 5);
		System.out.println(facade.listarTutores());
		
		System.out.println(facade.pegarNota("123456789"));
		int idAjuda = facade.pedirAjudaOnline("987654321", "LP2");
		System.out.println(facade.getInfoAjuda(idAjuda, "disciplina"));
		
		facade.avaliarTutor(idAjuda, 5);
		
		System.out.println(facade.pegarNota("123456789"));
		
		try {
			facade.salvar();
		} catch (IOException e) {
			System.out.println("Deu errado!");
		}
		*/
		try {
			facade.carregar();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Deu errado!");
		}
		
		System.out.println(facade.listarAlunos() + System.lineSeparator());
		System.out.println(facade.listarTutores());
		System.out.println(facade.pegarNota("123456789"));
	}

}
