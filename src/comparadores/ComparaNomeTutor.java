package comparadores;

import java.util.Comparator;

import qma.Aluno;
import qma.Tutor;

/**
 * Classe de implementação da comparação de {@link Tutor} por Nome, ordem lexicográfica.
 * Implementa a interface {@link Comparator}.
 * 
 * Projeto de LP2 - Quem me ajuda
 * 
 * @author Lucas Cordeiro Brasil
 * @author Mateus Queiroz Cunha
 * @author Joeberth Augusto Cordeiro de Souza
 * @author Vitor Alves Correia Lima de Aquino
 *
 */
public class ComparaNomeTutor implements Comparator<Tutor>{

	/**
	 * Método compare que irá comparar o Nome de dois Alunos, retornando menor que zero, caso o primeiro venha depois na ordem lexicográfica,
	 * maior que zero caso o primeiro venha antes na ordem lexicográfica e zero caso ambos os e-mails segam iguais. Em caso de mesma ordem lexicográfica,
	 * o desempate ocorre pela ordenação natural dos tutores.
	 */
	public int compare(Tutor a, Tutor b) {
		int valor = a.getAluno().getNome().compareTo(b.getAluno().getNome());
		if (valor != 0) {
			return valor;
		} else {
			return a.compareTo(b);
		}
	}
}


