
package model;

import java.util.ArrayList;

/**
 * Entidade Funcionário
 * 
 * @author morvanabonin
 */
public class Funcionario {
    
    private String nome;
    private String cargo;
    private final CPF cpf;
    private ArrayList<Competencia> competencias;
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
	this.competencias = competencias;
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

    public String dadosFuncionario() {
	return "Nome "+ this.nome + "\n"+ "Cargo: " + this.cargo + "\n" +"CPF: " + this.cpf;
    }
    
    public void setCompetencias(ArrayList<Competencia> competencias) {
	//competencias.add(Competencia competencia);
    }

    public ArrayList<Competencia> getCompetencias() {
	return competencias;
    }
    
}
