package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author estef
 */
@Entity
@Table(name = "livroemprestimo")
class LivroEmprestimo implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_livroemprestimo", sequenceName = "seq_livroemprestimo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_livroemprestimo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O emprestimo deve ser informado!")
    @ManyToOne
    @JoinColumn(name = "emprestimo", referencedColumnName = "id", nullable = false)
    private Emprestimo emprestimo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final LivroEmprestimo other = (LivroEmprestimo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
