package controller;

import dao.IFuncionarioDao;
import dao.FuncionarioDaoBd;
import model.CPF;
import model.Funcionario;

/**
 * Classe Controller Funcionário
 * @author morvanabonin
 */
public class FuncionarioController {
    
    public void funcionarioAction(){       
        Funcionario funcionario = new Funcionario("Daniela Gomes", "Gerente da Administração", new CPF("46774733743"));
        IFuncionarioDao dao = new FuncionarioDaoBd();
	
        dao.inserir(funcionario);
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
