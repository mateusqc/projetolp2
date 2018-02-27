package projeto;

import java.util.ArrayList;
import java.util.Map;

public class Tutor extends Funcao{

	private ArrayList<String> disciplinas = new ArrayList<String>();
	private ArrayList<String> horario = new ArrayList<String>();
	private ArrayList<String> local = new ArrayList<String>();
	private int proficiencia;
	private double dinheiro;
	private double notaAvaliacaoTutor;
	
	public Tutor(String disciplina, int proficiencia) {
		
		this.disciplinas.add(disciplina);
		this.setProficiencia(proficiencia);
		this.dinheiro = 0;
		this.notaAvaliacaoTutor = 4;
		
	}
	
	public String toString() {
		
		return this.toString();
		
	}
	
	public ArrayList<String> getDisciplinas() {
		
		return this.disciplinas;
		
	}
	
	public void cadastraHorario(String horario, String dia) {
		this.horario.add(dia + " - " + horario);
	}
	
	public void cadastraLocalDeAtendimento(String local) {
		this.local.add(local);
	}

	public ArrayList<String> getHorario() {
		return horario;
	}

	public ArrayList<String> getLocal() {
		return local;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(int proficiencia) {
		this.proficiencia = proficiencia;
	}
	
	
}