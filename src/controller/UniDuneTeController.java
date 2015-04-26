
package controller;

import java.util.ArrayList;
import model.CPF;
import model.Funcionario;

/**
 * Class Controller ArrayList
 * @author morvanabonin
 */
public class UniDuneTeController {
    
    public void executar(){
        
        Funcionario funcionario = new Funcionario("Mauro", "de confiança", new CPF("9999999"));
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        
        funcionarios.add(funcionario);
        
    }
       
}
