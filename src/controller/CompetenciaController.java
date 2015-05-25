package controller;

import dao.CompetenciaDaoBD;
import dao.ICompetenciaDao;
import model.Competencia;


/**
 * Classe Controller Competência
 * @author morvanabonin
 */
public class CompetenciaController {
    
    public void competenciaAction() {
	Competencia competencia = new Competencia("IX45", "Criatividade");
        ICompetenciaDao dao = new CompetenciaDaoBD();
	
	dao.inserir(competencia);
    }
}
