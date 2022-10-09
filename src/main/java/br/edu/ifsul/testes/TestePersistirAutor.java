package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author estef
 */
public class TestePersistirAutor {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-Biblioteca-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Autor a = new Autor();
        
        a.setNome("Colleen Hoover");
        
        em.getTransaction().begin();
        em.persist(a);  // persiste a autora criada
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
