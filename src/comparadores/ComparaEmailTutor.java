package comparadores;

import java.util.Comparator;

import qma.Tutor;

public class ComparaEmailTutor implements Comparator<Tutor>{

	public int compare(Tutor a, Tutor b) {
		int valor = a.getAluno().getEmail().compareTo(b.getAluno().getEmail());
		if (valor != 0) {
			return valor;
		}
		else {
			return a.getAluno().compareTo(b.getAluno());
		}
	}
}
