package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Instituicao;
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
public class TestePersistirInstituicao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("modelo-um-suelen-ModelPU");
        EntityManager em = emf.createEntityManager();
        Instituicao e = new Instituicao();
        e.setNome("IFSUL");
        e.setAnoFundacao("2005");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Instituicao>> erros = validador.validate(e);
        if (erros.size() > 0) {
            for (ConstraintViolation<Instituicao> erro : erros) {
                System.out.println("Erro: " + erro.getMessage());
            }
        } else {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }

}
