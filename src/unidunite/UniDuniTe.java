
package unidunite;

import controller.UniDuneTeController;
import java.sql.SQLException;

/**
 * Classe de execução do sistema (Main)
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
