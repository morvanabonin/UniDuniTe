package model;

/**
 * Entidade Competência
 *
 * @author morvanabonin
 */
public class Competencia {

    private String codigo;
    private String nome;

    /**
     * Construtor Competência
     * @param codigo
     * @param nome
     */
    public Competencia(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public Competencia() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String dadosCompetencia() {
	return "Codigo: " + this.codigo + "\n" + "Nome " + this.nome;
    }
}
