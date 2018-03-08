package projeto;

import java.util.Comparator;

public class ComparaEmail implements Comparator<Aluno> {

	public int compare(Aluno a, Aluno b) {
		int valor = a.getEmail().compareTo(b.getEmail());
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

