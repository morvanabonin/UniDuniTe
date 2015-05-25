
package model;

/**
 * Classe criada sobre o conceito de Tiny Types
 * @author morvanabonin
 */
public class CPF {
    
    private String cpf;

    /**
     * Construtor de inicialização do Tiny Types
     * @param cpf
     */
    public CPF(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
	return this.cpf;
    }

}
