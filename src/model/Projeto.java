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

    public Projeto(int codigo, String nome, Date dt_inicio, Date dt_fim, boolean aberto) {
	this.codigo = codigo;
	this.nome = nome;
	this.dt_inicio = dt_inicio;
	this.dt_fim = dt_fim;
	this.aberto = aberto;
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

}