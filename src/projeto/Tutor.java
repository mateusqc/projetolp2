package projeto;

import java.util.ArrayList;

public class Tutor extends Funcao{

	private ArrayList disciplinas = new ArrayList<String>();
	private int proficiencia;
	private double dinheiro;
	
	public Tutor(String disciplina, int proficiencia) {
		
		this.disciplinas.add(disciplina);
		this.proficiencia = proficiencia;
		this.dinheiro = 0;
		
	}
	
	public String toString() {
		
		return this.toString();
		
	}
	
	public ArrayList getDisciplinas() {
		
		return this.disciplinas;
		
	}
	
}