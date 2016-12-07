/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Instituicao;
import java.util.Calendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sowelus
 */
public class TestePersistirCurso {
    
    EntityManagerFactory emf;
    EntityManager em;
        
    public TestePersistirCurso() {
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
            Curso c = new Curso();
            c.setNome("sist");
            c.setSigla("TSPI");
            c.setDescricao("Aprenda a Programar");
            c.setAtivo(true);
            c.setInicioAtividades(Calendar.getInstance());
            c.setInstituicao(em.find(Instituicao.class, 4)); 
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


