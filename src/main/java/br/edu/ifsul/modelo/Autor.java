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
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author estef
 */
@Entity
@Table(name = "autor")
public class Autor implements Serializable{
    
   @Id
   @SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor_id", allocationSize = 1)
   @GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
   private Integer id;
   
   @NotBlank(message = "O nome deve ser informado!")
   @Length(max = 80, message = "O nome não pode ter mais que {max} caracteres!")
   @Column(name = "nome", nullable = false, length = 80) 
   private String nome;
   
   public Autor(){
       
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
  
}
