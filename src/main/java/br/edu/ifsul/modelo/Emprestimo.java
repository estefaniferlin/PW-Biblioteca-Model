
package br.edu.ifsul.modelo;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author estef
 */

@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_emprestimo", sequenceName = "seq_emprestimo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_emprestimo", strategy = GenerationType.SEQUENCE)
    private Integer id; 
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data do empréstimo deve ser informada!")
    @Column(name = "dtemprestimo", nullable = false)
    private Calendar dtEmprestimo = Calendar.getInstance();
    
    @NotNull(message = "Os livros do empréstimo devem ser informados!")
    @OneToMany(mappedBy = "emprestimo")
    private List<LivroEmprestimo> livros; //agregação por composição
    
    @NotNull(message = "O cliente deve ser informado!")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;
    
    public Emprestimo(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Calendar getDtCadastro() {
        return dtEmprestimo;
    }

    public void setDtCadastro(Calendar dtCadastro) {
        this.dtEmprestimo = dtCadastro;
    }

    public List<LivroEmprestimo> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroEmprestimo> livros) {
        this.livros = livros;
    }
  
} 
