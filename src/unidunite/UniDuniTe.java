
package unidunite;

import app.MainApp;
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
    public static void main(String[] args) throws SQLException, Exception {
        
        UniDuneTeController unidunite = new UniDuneTeController();
        //unidunite.executarAction();
	
	MainApp obj = new MainApp();
	obj.myApp(args);

    }
    
}
