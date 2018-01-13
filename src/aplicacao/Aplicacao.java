package aplicacao;
import dominio.Pessoa;

public class Aplicacao {

	public static void main(String[] args) {
	
		Pessoa pessoa1 = new Pessoa(1L, "Jack Bauer", "jb24@gmail.com");
		Pessoa pessoa2 = new Pessoa(2L, "Nina Meyers", "nina@gmail.com");
		Pessoa pessoa3 = new Pessoa(3L, "Ramón Salazar", "donramon@gmail.com");
		Pessoa pessoa4 = new Pessoa(4L, "David Palmer", "david_palmer@gmail.com");
		System.out.println(pessoa1);
		System.out.println(pessoa2);
		System.out.println(pessoa3);
		System.out.println(pessoa4);
		
	}
}
