package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    /**
    * Método de inserção de uma competencia no bd
    * @param competencia 
    */
    @Override
    public void inserir(Competencia competencia) {
	if (this._validaCodigo(competencia.getCodigo())) {
	    try {
		throw new Exception("Codigo já existe no Banco de Dados");
	    } catch (Exception ex) {
		Logger.getLogger(FuncionarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	    }
	} else {
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
    }
    
    /**
    * Método de deleção de uma competencia no bd
    * @param competencia 
    */
    @Override
    public void deletar(Competencia competencia) {
	id = _pegaIdCompetenciaPorCodigo(competencia);
	try {
            sql = "DELETE FROM competencia WHERE id=?";
	    conectar(sql);
	    comando.setInt(1, id);
	    comando.executeUpdate();
	    fechar(); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
	
    }
    
    /**
    * Método de atualização de uma competencia no bd
    * @param competencia 
    */
    @Override
    public void atualizar(Competencia competencia) {
	id = this._pegaIdCompetenciaPorCodigo(competencia);
        try {
	    sql = "UPDATE competencia SET codigo=?, nome=? WHERE id=?";
            conectar(sql);
            comando.setString(1, competencia.getCodigo());
            comando.setString(2, competencia.getNome());
	    comando.setInt(3, id);
            comando.executeUpdate();
            fechar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método de atualização por id de uma competencia no bd
     * 
     * @param id
     * @param competencia
     */
    @Override
    public void atualizarPorId(int id, Competencia competencia) {
        try {
	    sql = "UPDATE competencia SET codigo=?, nome=? WHERE id=?";
            conectar(sql);
            comando.setString(1, competencia.getCodigo());
            comando.setString(2, competencia.getNome());
	    comando.setInt(3, id);
            comando.executeUpdate();
            fechar();
	    
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    /**
     * Método para pegar o id do funcionário por cpf
     * 
     * @param competencia
     * @return id
     */
    private int _pegaIdCompetenciaPorCodigo(Competencia competencia) {
	try {
	    sql = "SELECT id FROM competencia WHERE codigo = ?";
	    conectar(sql);
	    comando.setString(1, competencia.getCodigo());
	    ResultSet resultado = comando.executeQuery();
	    if (resultado.next()) {
		id = resultado.getInt("id");
	    }
	    fechar();
	} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
	return id;
    }
    
    /**
     * Validação se já existe o código no banco de dados
     * 
     * @param codigo
     * @return true se codigo já existe | false se não existe
     */
    private boolean _validaCodigo(String codigo) {
	try {
	    sql = "SELECT codigo FROM competencia WHERE codigo = ?";
	    conectar(sql);
	    comando.setString(1, codigo);
	    ResultSet resultado = comando.executeQuery();
	    if (resultado.next()) {
		return true;
	    }
	    fechar();
	} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
	return false;
    }

}