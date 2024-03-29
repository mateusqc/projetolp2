package comparadores;

import java.util.Comparator;

import qma.Aluno;

public class ComparaNome implements Comparator<Aluno> {

	public int compare(Aluno a, Aluno b) {
		int valor = a.getNome().compareTo(b.getNome());
		if (valor != 0) {
			return valor;
		} else {
			return a.compareTo(b);
		}
	}
}