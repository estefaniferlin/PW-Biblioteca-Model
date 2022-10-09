/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author estef
 */
public class TestePersistirCliente {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-Biblioteca-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Cliente c = new Cliente();
        // id é gerado pela sequence
        c.setNome("Misael");
        c.setCpf("2014574120");
        c.setEmail("misael@teste");
        c.setTelefone("54984775478");
        
        em.getTransaction().begin();
        em.persist(c);  // persiste a categoria criada
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
