package controller;

import dao.IFuncionarioDao;
import dao.FuncionarioDaoBd;
import java.util.List;
import model.CPF;
import model.Funcionario;

/**
 * Classe Controller Funcionário
 * @author morvanabonin
 */
public class FuncionarioController {
    
    public void FuncionarioAction(){       
        Funcionario funcionario = new Funcionario("Daniela", "Gerente", new CPF("62324811510"));
        IFuncionarioDao dao = new FuncionarioDaoBd();
        dao.inserir(funcionario);
	dao.deletar(funcionario);
	dao.atualizar(funcionario);
	
	Funcionario func = dao.buscaPorCpf("96358228048");
	System.out.println(func.dadosFuncionario());
	
	
        
    }
}
