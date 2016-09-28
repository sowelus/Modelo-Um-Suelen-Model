package br.edu.ifsul.testes.junit;

    import br.edu.ifsul.modelo.Aluno;
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
public class TestePersisirAluno {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersisirAluno() {
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
            Aluno pf = new Aluno();
            pf.setNome("Jungkook");
            pf.setEmail("kookie@hotmail.com");
          //  pf.setNascimento(Calendar.getInstance());
            pf.setNascimento(new GregorianCalendar(1991, 4, 21));
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
