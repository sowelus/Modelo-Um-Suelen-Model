/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Suélen A. Camargo <s-a-camargo@hotmail.com>
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A primeira nota não pode ser nula")
    @Column(name = "nota01", nullable = false)
    private Double nota01;
    
    @NotNull(message = "A segunda nota não pode ser nula")
    @Column(name = "nota02", nullable = false)
    private Double nota02;
            
    @NotNull(message = "A media não não pode ser nula")
    @Column(name = "media", nullable = false)
    private Double media;

    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
    private Aluno aluno;
    
    @NotNull(message = "A Disciplina não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id", nullable = false)
    private Disciplina disciplina;

    
    public Nota() {
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
     * @return the nota01
     */
    public Double getNota01() {
        return nota01;
    }

    /**
     * @param nota01 the nota01 to set
     */
    public void setNota01(Double nota01) {
        this.nota01 = nota01;
    }

    /**
     * @return the nota02
     */
    public Double getNota02() {
        return nota02;
    }

    /**
     * @param nota02 the nota02 to set
     */
    public void setNota02(Double nota02) {
        this.nota02 = nota02;
    }

    /**
     * @return the media
     */
    public Double getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(Double media) {
        this.media = media;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
   
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.getId());
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
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}