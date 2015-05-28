package model;

import java.sql.Date;

/**
 * Entidade Projeto
 * 
 * @author morvanabonin
 */
public class Projeto {
    
    private int codigo;
    private String nome;
    private Date dt_inicio;
    private Date dt_fim;
    private boolean aberto;
    private String descricao;

    public Projeto(int codigo, String nome, Date dt_inicio, Date dt_fim, boolean aberto, String descricao) {
	this.codigo = codigo;
	this.nome = nome;
	this.dt_inicio = dt_inicio;
	this.dt_fim = dt_fim;
	this.aberto = aberto;
	this.descricao = descricao;
    }
    
    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(int codigo) {
	this.codigo = codigo;
    }
    
    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public Date getDt_inicio() {
	return dt_inicio;
    }

    public void setDt_inicio(Date dt_inicio) {
	this.dt_inicio = dt_inicio;
    }

    public Date getDt_fim() {
	return dt_fim;
    }

    public void setDt_fim(Date dt_fim) {
	this.dt_fim = dt_fim;
    }
    
    public void setAberto(boolean aberto) {
	this.aberto = aberto;
    }
    
    public boolean isAberto() {
	return aberto;
    }
    
    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }
    
    public String estadoProjeto() {
	String estado = this.isAberto() ? "aberto" : "fechado";
	return estado;
    }
    
    public String dadosProjeto() {
	
	return "Código: " + this.codigo 
		+ "\n Nome: " + this.nome
		+ "\n Data inicio: " + this.dt_inicio 
		+ "\n Data fim: " + this.dt_fim 
		+ "\n Estado do projeto : " + this.estadoProjeto()
		+ "\n Descrição: " + this.descricao;
    }

}
