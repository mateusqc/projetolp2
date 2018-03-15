package comparadores;

import java.util.Comparator;

import qma.Aluno;

/**
 * Classe de implementação da comparação de {@link Aluno} por E-mail, ordem lexicográfica.
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
public class ComparaEmail implements Comparator<Aluno> {

	/**
	 * Método compare que irá comparar o E-mail de dois Alunos retornando menor que zero, caso o primeiro venha depois na ordem lexicográfica,
	 * maior que zero caso o primeiro venha antes na ordem lexicográfica e zero caso ambos os e-mails segam iguais. Em caso de mesma ordem lexicográfica,
	 * o desempate ocorre pela ordenação natural dos alunos.
	 */
	public int compare(Aluno a, Aluno b) {
		int valor = a.getEmail().compareTo(b.getEmail());
		if (valor != 0) {
			return valor;
		} else {
			return a.compareTo(b);
		}
	}
}

