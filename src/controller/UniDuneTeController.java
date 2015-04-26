
package controller;

import dao.FuncionarioDao;
import dao.FuncionarioDaoBd;
import model.CPF;
import model.Funcionario;

/**
 * Class Controller ArrayList
 * @author morvanabonin
 */
public class UniDuneTeController {
    
    public void executar(){
        
        Funcionario funcionario = new Funcionario("Teste", "Meuteste2", new CPF("2487999999"));
        FuncionarioDao dao = new FuncionarioDaoBd();
        dao.inserir(funcionario);
        
    }
       
}
