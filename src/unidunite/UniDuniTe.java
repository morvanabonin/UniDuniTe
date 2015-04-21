/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidunite;

/**
 *
 * @author morvanabonin
 */
public class UniDuniTe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcionarios func = new Funcionarios("Mauro", "de confiança", new CPF("9999999"));
        System.out.println(func.getCpf());
        func.setCpf("124289849");     
        System.out.println(func.getCpf());
    }
    
}
