package aplicacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Aplicacao {

	public static void main(String[] args) {
	
		Pessoa pessoa1 = new Pessoa(1L, "Jack Bauer", "jb24@gmail.com");
		Pessoa pessoa2 = new Pessoa(2L, "Nina Meyers", "nina@gmail.com");
		Pessoa pessoa3 = new Pessoa(3L, "Ram�n Salazar", "donramon@gmail.com");
		Pessoa pessoa4 = new Pessoa(4L, "David Palmer", "david_palmer@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		System.out.println(pessoa1);
		System.out.println(pessoa2);
		System.out.println(pessoa3);
		System.out.println(pessoa4);
		
	}
}
