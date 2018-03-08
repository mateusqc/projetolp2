package projeto;

import java.util.Comparator;

public class ComparaEmailTutor implements Comparator<Tutor>{

	public int compare(Tutor a, Tutor b) {
		int valor = a.getAluno().getEmail().compareTo(b.getAluno().getEmail());
		if (valor != 0) {
			return valor;
		}
		else {
			if (a.getAluno().getMatricula().compareTo(b.getAluno().getMatricula()) < 0) {
				return 1;
			}
			else {
				return -1;
			}
		
		}
	}
}
