package projeto;

import java.util.Comparator;

public class ComparaMatriculaTutor implements Comparator<Tutor> {

	public int compare(Tutor a, Tutor b) {
		return a.getAluno().getMatricula().compareTo(b.getAluno().getMatricula());
	}
}