
package dao;

import java.util.ArrayList;
import model.Competencia;

/**
 * Classe 
 * 
 * @author morvanabonin
 */
public class FuncionarioCompetenciaDaoBD {
    
    /**
     * Inserção na tabela de Funcionario_has_Competencia
     * 
     * @param id
     * @param competencias
     */
    public void inserirCompetencia(int id, ArrayList<Competencia> competencias) {
	System.out.println("competencias : " + competencias + " Cheguei aqui");
	competencias.stream().forEach((competencia) -> {
	    CompetenciaDaoBD cdao = new CompetenciaDaoBD();
	    Competencia objcompetencia = cdao.buscaPorCodigo(competencia.getCodigo());
	});
    }

}
