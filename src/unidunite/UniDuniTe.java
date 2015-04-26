/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidunite;

import banco.ConnectionFactory;
import controller.UniDuneTeController;
import dao.FuncionarioDao;
import dao.FuncionarioDaoBd;
import java.sql.Connection;
import java.sql.SQLException;
import model.CPF;
import model.Funcionario;

/**
 *
 * @author morvanabonin
 */
public class UniDuniTe {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        UniDuneTeController teste = new UniDuneTeController();
        teste.executar();

    }
    
}
