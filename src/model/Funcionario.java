
package model;

import model.CPF;

/**
 * Classe de Funcionário
 * @author morvanabonin
 */
public class Funcionario {
    
    private String nome;
    private String cargo;
    private final CPF cpf;
    
    public Funcionario(String nome, String cargo, CPF cpf) {
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public String getCpf() {
        return cpf.getCpf();
    }
    
    public void setCpf(String cpf) {
        this.cpf.setCpf(cpf);
    }

}
