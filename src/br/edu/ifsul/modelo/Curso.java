
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Suélen A. Camargo <s-a-camargo@hotmail.com>
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE)
    private Integer id;
   
    @Length(max = 50, message = "O Nome não pode ter mais de {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Length(max = 10, message = "A Sigla não pode ter mais de {max} caracteres")
    @NotNull(message = "A sigla não pode ser nula")
    @NotBlank(message = "A sigla não pode estar em branco")
    @Column(name = "sigla", length = 10, nullable = false)
    private String sigla;
    
    @NotNull(message = "A sigla não pode ser nula")
    @NotBlank(message = "A sigla não pode estar em branco")    
    @Column(name = "descricao", columnDefinition = "text", nullable = false)
    private String descricao;
    
    @NotNull(message = "Ativo não pode ser nulo")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
      
    @Temporal(TemporalType.DATE)
    @Column(name = "inicioAtividades", nullable = false)
    private Calendar inicioAtividades;

    @ManyToOne
    @JoinColumn(name = "instituicao", referencedColumnName = "id", nullable = false)
    private Instituicao instituicao;
    
    public Curso() {
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

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the inicioAtividades
     */
    public Calendar getInicioAtividades() {
        return inicioAtividades;
    }

    /**
     * @param inicioAtividades the inicioAtividades to set
     */
    public void setInicioAtividades(Calendar inicioAtividades) {
        this.inicioAtividades = inicioAtividades;
    }
    
    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }             

    
   

}
