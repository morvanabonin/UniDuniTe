package controller;

import util.Console;

/**
 * Class Controller ArrayList
 * @author morvanabonin
 */
public class UniDuneTeController {
    public static final int FUNCIONARIO = 1;
    public static final int COMPETENCIA = 2;
    public static final int PROJETO = 3;
    
    public void executarAction() throws Exception {
        int opcao = 0;
	
	System.out.println(getOpcoes());
	
        do {
            System.out.println();
            opcao = Console.scanInt("Digite sua opção:");

            switch (opcao) {
		case FUNCIONARIO:
		    FuncionarioController funcionario = new FuncionarioController();
		    funcionario.funcionarioAction();
		break;
		case COMPETENCIA:
		    CompetenciaController competencia = new CompetenciaController();
		    competencia.competenciaAction();
		break;
		case PROJETO:
		    ProjetoController projeto = new ProjetoController();
		    projeto.projetoAction();
		break;
            }
        } while (opcao != 0);
    }
    
    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Funcionário \n"
                + "2- Competência \n"
                + "3- Projeto\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }   
}
