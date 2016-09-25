
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "disciplina")
public class Disciplina implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    private Integer id;
   
    @Length(max = 50, message = "O Nome não pode ter mais de {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "A descricao não pode ser nula")
    @NotBlank(message = "A descricao não pode estar em branco")    
    @Column(name = "descricao", columnDefinition = "text", nullable = false)
    private String descricao;
    
    @NotNull(message = "A carga horaria não pode ser nula")
    @Column(name = "carga_horaria", nullable = false)
    private Double cargaHoraria;
    
    @NotNull(message = "Os conhecimentos minimos não pode ser nula")
    @NotBlank(message = "Os conhecimentos minimos não pode estar em branco")    
    @Column(name = "conhecimentos_minimos", columnDefinition = "text", nullable = false)
    private String conhecimentosMinimos;  
    
    @NotNull(message = "O curso não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false)
    private Curso curso;
    
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY) 
    private List<Nota> notas = new ArrayList<>();     
    
    
    
    public Disciplina() {
    }  
    
    public void adicionarNota(Nota obj){
        obj.setDisciplina(this);
        this.notas.add(obj);
    }
    
    public void removerNota(int index){
        this.notas.remove(index);
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
     * @return the cargaHoraria
     */
    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the conhecimentosMinimos
     */
    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    /**
     * @param conhecimentosMinimos the conhecimentosMinimos to set
     */
    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }
    
    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }    
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.getId());
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    } 

 

    
}
