package aplicacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Aplicacao {

	public static void main(String[] args) {
	
		Pessoa pessoa1 = new Pessoa(null, "Jack Bauer", "jb24@gmail.com");
		Pessoa pessoa2 = new Pessoa(null, "Nina Meyers", "nina@gmail.com");
		Pessoa pessoa3 = new Pessoa(null, "Ram�n Salazar", "donramon@gmail.com");
		Pessoa pessoa4 = new Pessoa(null, "David Palmer", "david_palmer@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(pessoa1);
		em.persist(pessoa2);
		em.persist(pessoa3);
		em.persist(pessoa4);
		em.getTransaction().commit();
		
		System.out.println(pessoa1);
		System.out.println(pessoa2);
		System.out.println(pessoa3);
		System.out.println(pessoa4);
		
	}
}
