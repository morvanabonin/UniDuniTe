package controller;

import dao.IProjetoDao;
import dao.ProjetoDaoBD;
import java.sql.Date;
import model.Projeto;

/**
 * Classe Controller Projeto
 * 
 * @author morvanabonin
 */
public class ProjetoController {
    
    public void projetoAction(){
	
	Projeto projeto = new Projeto(1234, "Projeto Armagedon", new Date(2015-05-15), new Date(15-05-29), true);
	IProjetoDao dao = new ProjetoDaoBD();
	
	try {
	    dao.inserir(projeto);
	} catch (Exception ex) {
	    System.out.println(ex.getMessage());
	} 
    }
}
