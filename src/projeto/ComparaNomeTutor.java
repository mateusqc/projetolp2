package projeto;

import java.util.Comparator;

public class ComparaNomeTutor implements Comparator<Tutor>{

	public int compare(Tutor a, Tutor b) {
		int valor = a.getAluno().getNome().compareTo(b.getAluno().getNome());
		if (valor != 0) {
			return valor;
		} else {
			return a.getAluno().compareTo(b.getAluno());
		}
	}
}


