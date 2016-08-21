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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Suélen A. Camargo <s-a-camargo@hotmail.com>
 */
@Entity
@Table(name = "instituicao")
public class Instituicao implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_instituicao", sequenceName = "seq_instituicao_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_instituicao", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Length(max = 4, min = 4, message = "O ano de fundacao deve ter {max} caracteres")
    @NotNull(message = "O ano de fundacao não pode ser nulo")
    @NotBlank(message = "O ano de fundacao não pode estar em branco")    
    @Column(name = "ano_fundacao", length = 4, nullable = false)
    private String anoFundacao;

    public Instituicao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(String anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Instituicao other = (Instituicao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
 
    
    
    
    
}
