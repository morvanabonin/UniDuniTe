package controller;

/**
 * Class Controller ArrayList
 * @author morvanabonin
 */
public class UniDuneTeController {
    
    public void executar() {
	FuncionarioController funcionario = new FuncionarioController();
	//funcionario.funcionarioAction();
	
	CompetenciaController competencia = new CompetenciaController();
	competencia.competenciaAction();
    }
}
