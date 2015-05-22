
package controller;

import dao.IFuncionarioDao;
import dao.FuncionarioDaoBd;
import model.CPF;
import model.Funcionario;

/**
 * Class Controller ArrayList
 * @author morvanabonin
 */
public class UniDuneTeController {
    
    public void executar(){       
        Funcionario funcionario = new Funcionario("Teste", "Meu teste8", new CPF("2487999888"));
        IFuncionarioDao dao = new FuncionarioDaoBd();
        //dao.inserir(funcionario);
	//dao.deletar(funcionario);
	dao.atualizar(funcionario);
        
    }
       
}
