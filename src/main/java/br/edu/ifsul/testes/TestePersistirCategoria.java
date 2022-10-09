package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author estef
 */
public class TestePersistirCategoria {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-Biblioteca-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Categoria c = new Categoria();
        // id é gerado pela sequence
        c.setNome("Romance");
        
        em.getTransaction().begin();
        em.persist(c);  // persiste a categoria criada
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }
    
}
