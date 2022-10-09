package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Livro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author estef
 */
public class TestePersistirLivro {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-Biblioteca-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Livro l = new Livro();
        Categoria c = em.find(Categoria.class, 1);
        Autor a = em.find(Autor.class, 1);
        
        l.setQuantidade(10);
        l.setTitulo("É assim que acaba");
        l.setCategoria(c);
        l.setAutor(a);
        
        em.getTransaction().begin();
        em.persist(l);  // persiste o livro criado
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
