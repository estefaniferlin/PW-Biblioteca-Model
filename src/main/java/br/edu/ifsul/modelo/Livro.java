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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author estef
 */
@Entity
@Table(name = "livro")
public class Livro implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_livro", sequenceName = "seq_livro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_livro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O titulo deve ser informado!")
    @Length(max = 80, message = "O titulo não pode ter mais que {max} caracteres")
    @Column(name = "titulo", nullable = false, length = 80) 
    private String titulo;
    
    @NotBlank(message = "A quantidade deve ser informada!")
    @Length(max = 80, message = "A quantidade não pode ter mais que {max} caracteres")
    @Column(name = "quantidade", nullable = false) 
    private String quantidade;
       
    @NotNull(message = "O autor deve ser informado!")
    @ManyToOne
    @JoinColumn(name = "autor", referencedColumnName = "id", nullable = false)
    private Autor autor;
    
    @NotNull(message = "A categoria deve ser informada!")
    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "id", nullable = false)
    private Categoria categoria;
    
    public Livro(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    } 

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
  
}
