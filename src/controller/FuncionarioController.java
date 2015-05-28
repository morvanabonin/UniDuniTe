package controller;

import dao.IFuncionarioDao;
import dao.FuncionarioDaoBD;
import model.CPF;
import model.Funcionario;
import util.Console;

/**
 * Classe Controller Funcionário
 * @author morvanabonin
 */
public class FuncionarioController {
    
    public static final int INSERIR = 1;
    public static final int LISTAR = 2;
    public static final int ATUALIZAR = 3;
    public static final int ATUALIZARPORID = 4;
    public static final int BUSCARPORCPF = 5;
    public static final int BUSCARPORNOME = 6;
    public static final int DELETAR = 7;
    
    public void funcionarioAction(){
	
	
        Funcionario funcionario = new Funcionario("Daniela Gomes", "Gerente da Administração", new CPF("46774733749"));
	//TO DO, fazer um método que set as competencias
	//funcionario.setCompetencias();
        IFuncionarioDao dao = new FuncionarioDaoBD();
	
	int opcao = 0;
	
	System.out.println(getOpcoes());
	
        do {
            System.out.println();
            opcao = Console.scanInt("Digite sua opção:");

            switch (opcao) {
		case INSERIR:
		    try {
			dao.inserir(funcionario);
		    } catch (Exception ex) {
			System.out.println(ex.getMessage());
		    } 
		break;
		case LISTAR:
		    dao.listar().stream().forEach((f) -> {
			System.out.println(f.getNome());
		    });
		break;
		case ATUALIZAR:
		    dao.atualizar(funcionario);
		break;
		case ATUALIZARPORID:
		    dao.atualizarPorId(1, funcionario);
		break;
		case BUSCARPORCPF:
		    Funcionario func = dao.buscaPorCpf("46774733743");
		    System.out.println(func.dadosFuncionario());
		break;
		case BUSCARPORNOME:
		    dao.buscarPorNome("Daniela").stream().forEach((f) -> {
			System.out.println(f.getNome());
		    });
		break;
		case DELETAR:
		    dao.deletar(funcionario);
		break;
            }
        } while (opcao != 0);
    }
    
    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Novo Funcionario \n"
		+ "2- Listar Funcionario \n"
                + "3- Atualizar Funcionario \n"
                + "4- Atualizar Funcionario por id \n"
		+ "5- Buscar Funcionario por cpf \n"
		+ "6- Buscar Funcionario por cpf \n"
		+ "7- Deletar Funcionario \n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }  
}
