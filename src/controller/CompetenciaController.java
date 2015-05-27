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
	Competencia competencia = new Competencia("000AAD", "Criatividade");
        ICompetenciaDao dao = new CompetenciaDaoBD();
	
	//dao.inserir(competencia);
	//dao.deletar(competencia);
	//dao.atualizar(competencia);
	dao.atualizarPorId(1, competencia);
    }
}
