package controller;

import dao.CompetenciaDaoBD;
import dao.ICompetenciaDao;
import model.Competencia;


/**
 * Classe Controller Competência
 * @author morvanabonin
 */
public class CompetenciaController {
    
    public void competenciaAction() throws Exception {
	Competencia competencia = new Competencia("000AAD", "Criatividade");
        ICompetenciaDao dao = new CompetenciaDaoBD();
	
	try {
	    dao.inserir(competencia);
	} catch (Exception ex) {
	    System.out.println(ex.getMessage());
	} 
	
	dao.deletar(competencia);
	dao.atualizar(competencia);
	dao.atualizarPorId(1, competencia);
	
	Competencia comp = dao.buscaPorCodigo("000AAD");
	System.out.println(comp.dadosCompetencia());
	
	dao.buscarPorNome("C").stream().forEach((c) -> {
	    System.out.println(c.getNome());
	});
	
	dao.listar().stream().forEach((c) -> {
	    System.out.println(c.dadosCompetencia());
	});
    }
}
