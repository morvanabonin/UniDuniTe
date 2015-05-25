package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Competencia;

/**
 * Class Dao BD de Competência
 *
 * @author morvanabonin
 */
public class CompetenciaDaoBD implements ICompetenciaDao {
    
    private Connection conexao;
    private PreparedStatement comando;
    private String sql;  
    private int id;

    @Override
    public void inserir(Competencia competencia) {
	try {
	    sql = "INSERT INTO competencia(codigo, nome) VALUES (?, ?)";
	    conectar(sql);
	    comando.setString(1, competencia.getCodigo());
	    comando.setString(2, competencia.getNome());
	    comando.executeUpdate();
	    fechar();
	} catch (ClassNotFoundException | SQLException ex) {
	    Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @Override
    public void deletar(Competencia competencia) {
	
    }

    @Override
    public void atualizar(Competencia competencia) {
	
    }

    @Override
    public Competencia buscaPorId(int id) {
	return null;
    }

    @Override
    public List<Competencia> buscarPorNome(String nome) {
	return null;
    }

    @Override
    public List<Competencia> listar() {
	return null;
    }
    
    private void conectar(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql);
    }
    
    public void fechar() throws SQLException {
        comando.close();
        conexao.close();
    }

}