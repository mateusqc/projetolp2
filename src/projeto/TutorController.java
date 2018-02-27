package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TutorController {
	private Map<String, Tutor> tutores;
	
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia, Aluno aluno) {
		if(proficiencia < 1 || proficiencia > 5) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
		if(!tutores.containsKey(matricula)) {
			this.tutores.put(matricula, new Tutor(disciplina, proficiencia, aluno));
		} else {
			this.tutores.get(matricula).adicionarDisciplina(disciplina, proficiencia);
		}
	}

	public String recuperaTutor(String matricula) {
		if(!tutores.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por tutor: Tutor nao encontrado");
		}
		
		return this.tutores.get(matricula).toString();
	
	}

	public String listarTutores() {
		
		List<Tutor> tutoresOrdenadosNome = new ArrayList<Tutor>();
		
		for(Tutor tutor : this.tutores.values()) {
			tutoresOrdenadosNome.add(tutor);
		}
		
		Collections.sort(tutoresOrdenadosNome);
		
		String tutoresListados = "";
		for(int i=0; i < tutoresOrdenadosNome.size(); i++) {
			tutoresListados += tutoresOrdenadosNome.get(i).toString() + ", ";
		}
		return tutoresListados.substring(0, tutoresListados.length() - 2);
		
	}
}
