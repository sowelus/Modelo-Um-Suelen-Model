package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Suélen A. Camargo <s-a-camargo@hotmail.com>
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "aluno")
public class Aluno implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_aluno", strategy = GenerationType.SEQUENCE)
    private Integer id;
   
    @Length(max = 50, message = "O Nome não pode ter mais de {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Length(max = 50, message = "O email não pode ter mais de {max} caracteres")
    @NotNull(message = "O email não pode ser nula")
    @NotBlank(message = "O email não pode estar em branco")
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    
    @NotNull(message = "A data não pode estar em branco")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;

       
    public Aluno() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

     @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }             

  
    
   

}
