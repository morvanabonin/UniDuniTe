package controller;

import dao.IProjetoDao;
import dao.ProjetoDaoBD;
import java.sql.Date;
import model.Projeto;
import util.Console;

/**
 * Classe Controller Projeto
 * 
 * @author morvanabonin
 */
public class ProjetoController {
    
    public static final int INSERIR = 1;
    public static final int LISTAR = 2;
    public static final int ATUALIZAR = 3;
    public static final int LISTARABERTOS = 4;
    public static final int LISTARFECHADOS = 5;
    public static final int DELETAR = 6;
    
    public ProjetoController() {
	IProjetoDao dao = new ProjetoDaoBD();
    }
    
    public void projetoAction(){
	
	int opcao = 0;
	
	System.out.println(getOpcoes());
	
        do {
            System.out.println();
            opcao = Console.scanInt("Digite sua opção:");

            switch (opcao) {
		case INSERIR:
		    
		break;
		case LISTAR:
		    
		break;
		case ATUALIZAR:
		    
		break;
		case LISTARABERTOS:
		    
		break;
		case LISTARFECHADOS:
		    
		break;
		case DELETAR:
		    
		break;
            }
        } while (opcao != 0);
	
//	Projeto projeto = new Projeto(1234, "Projeto Andromeda", new Date(2015-05-15), new Date(15-05-29), false, "Projeto da Constelação");
//	IProjetoDao dao = new ProjetoDaoBD();
//	
//	try {
//	    dao.inserir(projeto);
//	} catch (Exception ex) {
//	    System.out.println(ex.getMessage());
//	} 
//	dao.deletar(1234);
//	dao.atualizar(1235, projeto);
//	
//	dao.listar().stream().forEach((p) -> {
//	    System.out.println(p.dadosProjeto());
//	});
//	
//	dao.listarProjetosAbertos().stream().forEach((pAbertos) -> {
//	    System.out.println(pAbertos.dadosProjeto());
//	});
//	
//	dao.listarProjetosFechados().stream().forEach((pFechados) -> {
//	    System.out.println(pFechados.dadosProjeto());
//	});
    }
    
    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Novo Projeto \n"
                + "2- Atualizar Projeto \n"
                + "3- Listar Projetos \n"
		+ "4- Listar Projetos Abertos \n"
		+ "5- Listar Projetos Fechados \n"
		+ "6- Deletar Projeto \n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }  
    
    public void insereNovoProjeto(){

    }
    
}
