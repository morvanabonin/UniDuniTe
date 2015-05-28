package controller;

import dao.IProjetoDao;
import dao.ProjetoDaoBD;
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
    
    public void projetoAction(){
	
	Projeto projeto = new Projeto(1245, "Projeto Órion", new java.sql.Date(2015-05-15), new java.sql.Date(15-05-29), false, "Projeto Galáxia");
	IProjetoDao dao = new ProjetoDaoBD();
	
	int opcao = 0;
	
	System.out.println(getOpcoes());
	
        do {
            System.out.println();
            opcao = Console.scanInt("Digite sua opção:");

            switch (opcao) {
		case INSERIR:
		    try {
			dao.inserir(projeto);
		    } catch (Exception ex) {
			System.out.println(ex.getMessage());
		    } 
		break;
		case LISTAR:
		    dao.listar().stream().forEach((p) -> {
			System.out.println(p.dadosProjeto());
		    });
		break;
		case ATUALIZAR:
		    dao.atualizar(1235, projeto);
		break;
		case LISTARABERTOS:
		    dao.listarProjetosAbertos().stream().forEach((pAbertos) -> {
			System.out.println(pAbertos.dadosProjeto());
		    });
		break;
		case LISTARFECHADOS:
		    dao.listarProjetosFechados().stream().forEach((pFechados) -> {
			System.out.println(pFechados.dadosProjeto());
		    });
		break;
		case DELETAR:
		    dao.deletar(1234);
		break;
            }
        } while (opcao != 0);
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
	System.out.println("Novo projeto: ");
	int codigo = Console.scanInt("Digite um código: ");
	String nome = Console.scanString("Digite um nome: ");
	
    }
}
