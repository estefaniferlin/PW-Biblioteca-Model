package br.edu.ifsul.modelo;

import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author estef
 */
@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cliente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado!")
    @Length(max = 80, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 80) 
    private String nome;
    
    @NotBlank(message = "O CPF deve ser informado!") 
    @Length(max = 11, min = 11, message = "O CPF deve ter {max} caracteres!")
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;
    
    @NotBlank(message = "O telefone deve ser informado!") 
    @Length(max = 11, min = 10, message = "O telefone deve entre {min} e {max} caracteres!")
    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;
    
    @NotBlank(message = "O e-mail deve ser informado!") // restrição para rejeitar campo em branco
    @Length(max = 80, message = "O e-mail não pode ter mais que {max} caracteres!") // restrição para tamanho
    @Column(name = "email", nullable = false, length = 80)
    private String email;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de cadastro deve ser informada!")
    @Column(name = "dtcadastro", nullable = false)
    private Calendar dtCadastro = Calendar.getInstance();
    
    public Cliente(){
        
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Calendar dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
