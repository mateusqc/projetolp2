package projeto;

import java.util.Comparator;

public class comparaNome implements Comparator<Aluno> {

	public int compare(Aluno a, Aluno b) {
		int valor = a.getNome().compareTo(b.getNome());
		if (valor != 0) {
			return valor;
		}
		else {
			if (a.getMatricula().compareTo(b.getMatricula()) < 0) {
				return 1;
			}
			else {
				return -1;
			}
		
		}
	}
}