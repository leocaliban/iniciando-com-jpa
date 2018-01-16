package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class AplicacaoRecuperar {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa pessoa = em.find(Pessoa.class, 2L);
		
		System.out.println(pessoa);
		
		em.close();
		emf.close();

	}

}
