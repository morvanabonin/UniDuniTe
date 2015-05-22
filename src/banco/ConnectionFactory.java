package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Factory de conexão com o Banco de Dados
 * @author morvanabonin
 */
public class ConnectionFactory {
   
    private static final String HOSTNAME = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "unidunite";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    /**
     * Metodo de conexão com o Banco de Dados
     * @return conexao
     */
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://"+HOSTNAME+":"+PORT+"/"+DATABASE;
            Connection conexao = DriverManager.getConnection(url,USER,PASSWORD);
            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
}
