
package model;

/**
 * Classe de Funcionário
 * @author morvanabonin
 */
public class Funcionario {
    
    private int id;
    private String nome;
    private String cargo;
    private final CPF cpf; 
    
    /**
     * Construtor Funcionário
     * @param nome
     * @param cargo
     * @param cpf 
     */
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

    public int getId() {
        return id;  
    }

    public void setId(int id) {
        this.id = id;
    }
}
