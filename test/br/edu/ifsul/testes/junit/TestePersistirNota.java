/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.edu.ifsul.modelo.Nota;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sowelus
 */
public class TestePersistirNota {
    
    EntityManagerFactory emf;
    EntityManager em;
        
    public TestePersistirNota() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("modelo-um-suelen-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void teste(){
        Boolean exception = false;
        try {
            Disciplina d = em.find(Disciplina.class, 2);
            Nota c = new Nota();
            c.setNota01(8.0);
            c.setNota02(9.0);
            c.setMedia(8.5);
            c.setAluno(em.find(Aluno.class, 20)); 
            d.adicionarNota(c);
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //comparo o resultado esperado (falso) com o que ocorreu
        Assert.assertEquals(false, exception);
    }
    
}


