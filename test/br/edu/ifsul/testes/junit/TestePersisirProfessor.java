package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Professor;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersisirProfessor {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersisirProfessor() {
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
        boolean exception = false; // variavel que vai armazenar o resultado do teste
        try {
            Professor pf = new Professor();
            pf.setNome("Jungkook");
            pf.setEmail("kookie@hotmail.com");
            pf.setNascimento(Calendar.getInstance());
            
            pf.setTitulacao("Graduado");
            pf.setTopicosDeInteresse("Cloud Computing, computação móvel");
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        // comparo o resultado esperado(falso) com o que ocorreu
        Assert.assertEquals(false, exception);
        
    }
    
}
