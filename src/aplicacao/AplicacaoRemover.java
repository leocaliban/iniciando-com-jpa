package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class AplicacaoRemover {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa pessoa = em.find(Pessoa.class, 3L);
		
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
