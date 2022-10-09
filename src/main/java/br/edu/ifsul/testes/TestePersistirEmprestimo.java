package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Emprestimo;
//import br.edu.ifsul.modelo.Emprestimo;
import br.edu.ifsul.modelo.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author estef
 */

public class TestePersistirEmprestimo {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-Biblioteca-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Emprestimo e = new Emprestimo();
        // id é gerado pela sequence
        Cliente c = em.find(Cliente.class, 2);

        e.setCliente(c);
        
        em.getTransaction().begin();
        em.persist(e);  // persiste a categoria criada
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}

