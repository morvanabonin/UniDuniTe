package controller;

import dao.IFuncionarioDao;
import dao.FuncionarioDaoBD;
import model.CPF;
import model.Funcionario;

/**
 * Classe Controller Funcionário
 * @author morvanabonin
 */
public class FuncionarioController {
    
    public void funcionarioAction(){       
        Funcionario funcionario = new Funcionario("Daniela Gomes", "Gerente da Administração", new CPF("46774733749"));
	//TO DO, fazer um método que set as competencias
	//funcionario.setCompetencias();
        IFuncionarioDao dao = new FuncionarioDaoBD();
	
	try {
	    dao.inserir(funcionario);
	} catch (Exception ex) {
	    System.out.println(ex.getMessage());
	} 
	
	dao.deletar(funcionario);
	dao.atualizar(funcionario);
	dao.atualizarPorId(1, funcionario);
	
	Funcionario func = dao.buscaPorCpf("46774733743");
	System.out.println(func.dadosFuncionario());
	
	dao.buscarPorNome("Daniela").stream().forEach((f) -> {
	    System.out.println(f.getNome());
	});
	
	dao.listar().stream().forEach((f) -> {
	    System.out.println(f.getNome());
	});
    }
}
