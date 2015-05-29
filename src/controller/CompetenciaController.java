package controller;

import dao.CompetenciaDaoBD;
import dao.ICompetenciaDao;
import model.Competencia;
import model.Funcionario;
import util.Console;


/**
 * Classe Controller Competência
 * @author morvanabonin
 */
public class CompetenciaController {
    
    public static final int INSERIR = 1;
    public static final int LISTAR = 2;
    public static final int ATUALIZAR = 3;
    public static final int ATUALIZARPORID = 4;
    public static final int BUSCARPORCODIGO = 5;
    public static final int BUSCARPORNOME = 6;
    public static final int DELETAR = 7; 
    
    public void competenciaAction() throws Exception {
	
	Competencia competencia = new Competencia("000AAB", "Pontualidade");
        ICompetenciaDao dao = new CompetenciaDaoBD();
	
	int opcao = 0;
	
	System.out.println(getOpcoes());
	
        do {
            System.out.println();
            opcao = Console.scanInt("Digite sua opção:");

            switch (opcao) {
		case INSERIR:
		    try {
			dao.inserir(competencia);
		    } catch (Exception ex) {
			System.out.println(ex.getMessage());
		    } 
		break;
		case LISTAR:
		    dao.listar().stream().forEach((c) -> {
			System.out.println(c.dadosCompetencia());
		    });
		break;
		case ATUALIZAR:
		    dao.atualizar(competencia);
		break;
		case ATUALIZARPORID:
		    dao.atualizarPorId(1, competencia);
		break;
		case BUSCARPORCODIGO:
		    Competencia comp = dao.buscaPorCodigo("000AAD");
		    System.out.println(comp.dadosCompetencia());
		break;
		case BUSCARPORNOME:
		    dao.buscarPorNome("C").stream().forEach((c) -> {
			System.out.println(c.getNome());
		    });
		break;
		case DELETAR:
		    dao.deletar(competencia);
		break;
            }
        } while (opcao != 0);
    }
    
    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Nova Competência \n"
		+ "2- Listar Competências \n"
                + "3- Atualizar Competência \n"
                + "4- Atualizar Competência por id \n"
		+ "5- Buscar Competência por código \n"
		+ "6- Buscar Competência por nome \n"
		+ "7- Deletar Competência \n"
                + "0- Voltar"
                + "\n--------------------------------------");
    } 
}
