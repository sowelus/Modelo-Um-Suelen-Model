package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
            pf.setNome("Jorge");
            pf.setEmail("jorge@hotmail.com");
            pf.setNascimento(new GregorianCalendar(1991, 4, 21));            
            pf.setTitulacao("Graduado");
            pf.setTopicosDeInteresse("Cloud Computing, computação móvel");
            pf.setEspecialidade(em.find(Especialidade.class, 9)); 
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
