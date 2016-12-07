/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Suélen A. Camargo <s-a-camargo@hotmail.com>
 */
@Entity
@Table(name = "professor")
public class Professor extends Aluno implements Serializable {
    
    @Length(max = 50, message = "A Titulação não pode ter mais de {max} caracteres")
    @NotBlank(message = "A Titulação não pode estar em branco")
    @Column(name = "titulacao", length = 50, nullable = false)
    private String titulacao;
    
  
    @NotNull(message = "O campo tópicos de interesse não podem estar nulo")
    @NotBlank(message = "O campo tópicos de interesse não podem estar em branco")
    @Column(name = "topicosDeInteresse", columnDefinition = "text", nullable = false)
    private String topicosDeInteresse;
    
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    private Especialidade especialidade; 
    
   
    public Professor() {
    }

    /**
     * @return the titulacao
     */
    public String getTitulacao() {
        return titulacao;
    }

    /**
     * @param titulacao the titulacao to set
     */
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    /**
     * @return the topicosDeInteresse
     */
    public String getTopicosDeInteresse() {
        return topicosDeInteresse;
    }

    /**
     * @param topicosDeInteresse the topicosDeInteresse to set
     */
    public void setTopicosDeInteresse(String topicosDeInteresse) {
        this.topicosDeInteresse = topicosDeInteresse;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }




   
    
    
    
    
}
