package projeto;

import java.util.Comparator;

public class ComparaMatricula implements Comparator<Aluno> {

	public int compare(Aluno a, Aluno b) {
		return a.getMatricula().compareTo(b.getMatricula());
	}
}
		