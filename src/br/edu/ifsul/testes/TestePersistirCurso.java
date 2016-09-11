package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Curso;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Suélen A. Camargo <s-a-camargo@hotmail.com>
 */
public class TestePersistirCurso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("modelo-um-suelen-ModelPU");
        EntityManager em = emf.createEntityManager();
        Curso c = em.find(Curso.class, 2);
        c.setNome("Sistemas");
        c.setSigla("TSPI");
        c.setDescricao("Aprenda a Programar");
        c.setAtivo(true);
        c.setInicioAtividades(Calendar.getInstance());
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Curso>> erros = validador.validate(c);
        if (erros.size() > 0) {
            for (ConstraintViolation<Curso> erro : erros) {
                System.out.println("Erro: " + erro.getMessage());
            }
        } else {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }

}